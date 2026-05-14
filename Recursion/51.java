class Solution {
    public boolean isSafe(String board[][],int row,int col,int n){
        for(int i=0;i<n;i++){
            if(board[i][col].equals("Q")) return false;
        }
         for(int i=0;i<n;i++){
            if(board[row][i].equals("Q")) return false;
        }
        // left diagonal
        for(int i=row,j=col;i>=0&&j>=0;i--,j--){
            if(board[i][j].equals("Q")) return false;
        }

        // right diagonal
         for(int i=row,j=col;i>=0&&j<n;i--,j++){
            if(board[i][j].equals("Q")) return false;
        }
        return true;

    }
    public List<String> construct(String[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            res.add(String.join("", board[i]));
        }
        return res;
    }
    public void nQueens(String[][] board,int row,int n,List<List<String>> ans){
        if(row == n){
            ans.add(construct(board));
            return;
        }
        for(int j=0;j<n;j++){
               if(isSafe(board,row,j,n)){
                  board[row][j] = "Q";
                  nQueens(board,row+1,n,ans);
                  // Backtrack
                  board[row][j] = ".";
               }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        String board[][] = new String[n][n];
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++) board[i][j] = ".";
        }
        nQueens(board,0,n,ans);
        return ans;

    }
}
