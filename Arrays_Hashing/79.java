class Solution {
    int r[] = {-1,1,0,0};
    int c[] = {0,0,-1,1};


    public boolean dfs(char[][] board,int row,int col,String word,int idx){
        if(idx == word.length()) return true;
        if(row<0 || col<0 || row>board.length-1||col>board[0].length-1||board[row][col]!=word.charAt(idx)){
            return false;
        }
       
       char temp = board[row][col];
       board[row][col] = '@';
       for(int i=0;i<4;i++){
            int newRow = row + r[i];
            int newCol = col+ c[i];
            if(dfs(board,newRow,newCol,word,idx+1)) return true;
       }
       // Backtrack step
       board[row][col] = temp;
       return false;

    }

    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0)){
                    if(dfs(board,i,j,word,0)) return true;
                }
            }
        }
        return false;
    }
}
