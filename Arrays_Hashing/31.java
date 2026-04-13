class Solution {
    public void revArr(int[] arr,int s,int e){
        while(s<=e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public void nextPermutation(int[] nums) {
        int idx = -1;
        int n = nums.length;
        for(int i=n-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                idx = i;
                break;
            }
        }
        if(idx == -1) revArr(nums,0,n-1);
        else{
            for(int i = n-1;i>=idx;i--){
                if(nums[i]>nums[idx]){
                    int temp = nums[idx];
                    nums[idx] = nums[i];
                    nums[i]= temp;
                    break;
                }
            }
            revArr(nums,idx+1,n-1);
        }

    }
}
