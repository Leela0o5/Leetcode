class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> arr = new ArrayList<>();
        arr.add(new int[]{1,0});
        for(int r[]:restrictions) arr.add(r);
        arr.add(new int[]{n,n-1});
        arr.sort((a,b)->a[0]-b[0]);
        // left to right
        for(int i=1;i<arr.size();i++){
            int d = arr.get(i)[0] - arr.get(i-1)[0];
            arr.get(i)[1] = Math.min(arr.get(i)[1],arr.get(i-1)[1]+d);
        }
        //right to left
        for(int i=arr.size()-2;i>=0;i--){
             int d = arr.get(i+1)[0] - arr.get(i)[0];
            arr.get(i)[1] = Math.min(arr.get(i)[1],arr.get(i+1)[1]+d);
        }
        int ans = 0;


        for(int i=1;i<arr.size();i++){
             int d = arr.get(i)[0] - arr.get(i-1)[0];
             int h1 = arr.get(i-1)[1];
             int h2 = arr.get(i)[1];

            int peak = (h1+h2+d)/2;
            ans = Math.max(ans,peak);


        }
        return ans;
    }
}
