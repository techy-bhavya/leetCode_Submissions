import java.util.*;

class Solution {
    private int[] start, end;
    private int timer;
    private int[][] up;
    private int LOG;
    private int[] tree;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        // 1. Build the tree adjacency list
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        // 2. Setup LCA (Binary Lifting) and Euler Tour arrays
        LOG = (int) (Math.log(n) / Math.log(2)) + 1;
        up = new int[n][LOG];
        start = new int[n];
        end = new int[n];
        timer = 1; // 1-based indexing for Fenwick Tree

        dfs(0, 0, adj);

        // 3. Initialize Fenwick Tree with the starting character states
        // Size is 2 * n + 2 because each node has distinct entry and exit time positions
        tree = new int[2 * n + 2];
        char[] chars = s.toCharArray();
        for (int i = 0; i < n; i++) {
            int mask = 1 << (chars[i] - 'a');
            updateBIT(start[i], mask);
            updateBIT(end[i], mask);
        }

        // 4. Process the queries list
        List<Boolean> ansList = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int node = Integer.parseInt(parts[1]);
                char newChar = parts[2].charAt(0);
                
                // Get the difference between the old state and new state via XOR
                int oldMask = 1 << (chars[node] - 'a');
                int newMask = 1 << (newChar - 'a');
                int updateMask = oldMask ^ newMask;

                // Update both positions of the node in the flattened array
                updateBIT(start[node], updateMask);
                updateBIT(end[node], updateMask);
                chars[node] = newChar; 
                
            } else { // "query" type
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int lcaNode = getLCA(u, v);

                // XOR paths from the root to u, and root to v
                int maskU = queryBIT(start[u]);
                int maskV = queryBIT(start[v]);
                int pathMask = maskU ^ maskV;

                // Re-apply the LCA node's individual mask since it gets cancelled out in the XOR
                int lcaMask = 1 << (chars[lcaNode] - 'a');
                pathMask ^= lcaMask;

                // If pathMask has at most 1 bit set to 1, it can be rearranged into a palindrome
                boolean isPalindrome = (pathMask & (pathMask - 1)) == 0;
                ansList.add(isPalindrome);
            }
        }

        return ansList;
    }

    // DFS to precompute Binary Lifting values and flattening timestamps
    private void dfs(int node, int p, List<Integer>[] adj) {
        start[node] = timer++;
        up[node][0] = p;
        for (int i = 1; i < LOG; i++) {
            up[node][i] = up[up[node][i - 1]][i - 1];
        }

        for (int neighbor : adj[node]) {
            if (neighbor != p) {
                dfs(neighbor, node, adj);
            }
        }
        end[node] = timer++;
    }

    // Direct check if node u is an ancestor of node v
    private boolean isAncestor(int u, int v) {
        return start[u] <= start[v] && end[u] >= end[v];
    }

    // Finds the Lowest Common Ancestor (LCA) using Binary Lifting
    private int getLCA(int u, int v) {
        if (isAncestor(u, v)) return u;
        if (isAncestor(v, u)) return v;
        for (int i = LOG - 1; i >= 0; i--) {
            if (!isAncestor(up[u][i], v)) {
                u = up[u][i];
            }
        }
        return up[u][0];
    }

    // Fenwick Tree (BIT) Point Updates
    private void updateBIT(int idx, int val) {
        for (; idx < tree.length; idx += idx & -idx) {
            tree[idx] ^= val;
        }
    }

    // Fenwick Tree (BIT) Prefix Queries
    private int queryBIT(int idx) {
        int sum = 0;
        for (; idx > 0; idx -= idx & -idx) {
            sum ^= tree[idx];
        }
        return sum;
    }
}
