class Solution {
    public int uniquePaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long MOD = 1_000_000_007;

        // target[r][c][0] stores the actual landing cell (encoded as r * n + c) 
        // if we attempt to move RIGHT into (r, c).
        // target[r][c][1] stores the landing cell if we attempt to move DOWN into (r, c).
        // A value of -1 means the path goes out of bounds.
        int[][][] target = new int[m][n][2];

        // Precompute the redirection targets from bottom-right to top-left
        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (grid[r][c] == 0) {
                    // Empty cell: robot lands exactly here
                    target[r][c][0] = r * n + c;
                    target[r][c][1] = r * n + c;
                } else {
                    // Mirror cell: redirect based on incoming direction
                    
                    // Coming from LEFT, trying to move RIGHT into (r, c) -> Deflected DOWN to (r + 1, c)
                    if (r + 1 < m) {
                        target[r][c][0] = target[r + 1][c][1];
                    } else {
                        target[r][c][0] = -1; // Out of bounds
                    }

                    // Coming from TOP, trying to move DOWN into (r, c) -> Deflected RIGHT to (r, c + 1)
                    if (c + 1 < n) {
                        target[r][c][1] = target[r][c + 1][0];
                    } else {
                        target[r][c][1] = -1; // Out of bounds
                    }
                }
            }
        }

        // dp[r][c] stores the number of valid paths from (r, c) to (m-1, n-1)
        long[][] dp = new long[m][n];
        dp[m - 1][n - 1] = 1; // Base case: 1 way to stay at the destination

        for (int r = m - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (grid[r][c] == 1 || (r == m - 1 && c == n - 1)) {
                    continue; // Skip mirrors and the destination cell
                }

                long paths = 0;

                // 1. Try moving RIGHT to (r, c + 1)
                if (c + 1 < n) {
                    int landing = target[r][c + 1][0];
                    if (landing != -1) {
                        paths = (paths + dp[landing / n][landing % n]) % MOD;
                    }
                }

                // 2. Try moving DOWN to (r + 1, c)
                if (r + 1 < m) {
                    int landing = target[r + 1][c][1];
                    if (landing != -1) {
                        paths = (paths + dp[landing / n][landing % n]) % MOD;
                    }
                }

                dp[r][c] = paths;
            }
        }

        return (int) dp[0][0];
    }
}
