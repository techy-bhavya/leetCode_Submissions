class Solution {

    public static boolean isSafeToPlaceHere(boolean[][] board, int row, int col, int n){
        int[][] dirs = {{-1,-1},{-1,0},{-1,1}};
        for(int rad=1;rad<=n;rad++){
            for(int[] dir: dirs){
                int nRow = row+ rad*dir[0];
                int nCol = col+ rad*dir[1];
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<n && board[nRow][nCol]==true){
                    return false;
                }
            }
        }
        return true;
    }

    public static void nQueens(boolean[][] board, int n, int row, List<List<String>> result){
        if(row==n){
            List<String> sol = new ArrayList<>();
            for(int i=0;i<n;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++){
                    if(board[i][j]){
                        sb.append("Q");
                    }
                    else{
                        sb.append(".");
                    }
                }
                sol.add(sb.toString());
            }
            result.add(sol);
            return;
        }

        for(int col=0;col<n;col++){
            if(isSafeToPlaceHere(board, row, col, n)){
                board[row][col] = true;
                nQueens(board, n, row+1, result);
                board[row][col] = false;
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> res = new ArrayList<>();
        nQueens(board, n, 0, res);
        return res;
    }
}