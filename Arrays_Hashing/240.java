class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int row = 0;
        int col = mat[0].length-1;
        while(row<=mat.length-1 && col>=0){
            int curr = mat[row][col];
            if(curr == target) return true;
            else if(curr > target) col--;
            else if(curr < target) row++;
        }
        return false;
    }
}
