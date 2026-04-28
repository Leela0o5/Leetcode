class Solution {

    public boolean canDistribute(int[] arr,int k,int n){
        int storeCnt = 0;
        for(int i = 0;i<arr.length;i++){
           
                 storeCnt+=(int)(Math.ceil((double)arr[i]/k));
        }
        return storeCnt<=n;

    }
    public int minimizedMaximum(int n, int[] quantities) {
        int high = 0;
        for (int q : quantities) {
            high = Math.max(high, q);
        }
        int low = 1;
        int ans = -1;
        while(low<=high){
            int mid = (low+high)/2;
            if(!canDistribute(quantities,mid,n)) low = mid+1;
            else{
                ans = mid;
                high = mid-1;
            }
        }
        return ans;
    }
}
