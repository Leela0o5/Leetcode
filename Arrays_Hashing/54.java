class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ans = new ArrayList<>();
        int m = mat.length;
        int n = mat[0].length;
        int top = 0;
        int right = n-1;
        int left = 0;
        int bottom = m-1;
        while(left<=right && top<=bottom){
            for(int i=left;i<=right;i++){
                ans.add(mat[top][i]);
            }
            top++;
            for(int i=top;i<=bottom;i++){
                ans.add(mat[i][right]);
            }
            right--;
            
            if(top<=bottom){
                for(int i=right;i>=left;i--){
                    ans.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                  for(int i =bottom;i>=top;i--){
                          ans.add(mat[i][left]);
                  }
                  left++;
            }
        }
        return ans;
    }
}
