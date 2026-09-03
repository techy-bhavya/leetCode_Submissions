class Solution {

    public static boolean isSafeToPlaceHere(boolean[][] board, int row, int col, int n) {
        int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}};

        for (int rad = 1; rad <= n; rad++) {
            for (int[] dir : dirs) {
                int nRow = row + rad * dir[0];
                int nCol = col + rad * dir[1];

                if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < n
                        && board[nRow][nCol]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static int nQueens(boolean[][] board, int n, int row) {

        if (row == n) {
            return 1;  // found one valid solution
        }

        int count = 0;

        for (int col = 0; col < n; col++) {

            if (isSafeToPlaceHere(board, row, col, n)) {

                board[row][col] = true;

                count += nQueens(board, n, row + 1);

                board[row][col] = false;
            }
        }

        return count;
    }

    public int totalNQueens(int n) {

        boolean[][] board = new boolean[n][n];

        return nQueens(board, n, 0);
    }
}