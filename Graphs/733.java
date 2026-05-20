class Solution {
    public void dfs(int[][] img,int i,int j,int color,int orgColor){
        if(j<0 || i<0 || i>=img.length || j>=img[0].length || img[i][j] != orgColor|| img[i][j] == color) return;
        img[i][j] = color;
        dfs(img,i-1,j,color,orgColor);
        dfs(img,i+1,j,color,orgColor);
        dfs(img,i,j-1,color,orgColor);
        dfs(img,i,j+1,color,orgColor);

    }
    public int[][] floodFill(int[][] img, int sr, int sc, int color) {
        dfs(img,sr,sc,color,img[sr][sc]);
        return img;
    }
}
