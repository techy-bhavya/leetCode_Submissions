class Solution {
    public String[] createGrid(int m, int n) {
        char[][] g = new char[m][n];
        
        // Fill the grid with obstacles ('#')
        for (int i = 0; i < m; i++) {
            Arrays.fill(g[i], '#');
        }
        
        // Make the entire first row free cells ('.')
        Arrays.fill(g[0], '.');
        
        // Make the last column free cells ('.') down each row
        for (int i = 0; i < m; i++) {
            g[i][n - 1] = '.';
        }
        
        // Convert character array rows to String[]
        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            ans[i] = new String(g[i]);
        }
        
        return ans;
    }
}

