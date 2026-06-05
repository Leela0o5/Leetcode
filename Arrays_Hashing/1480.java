class Solution {
    public int[] runningSum(int[] nums) {
        int ans[] = new int[nums.length];
        int temp = 0;
        int k =0;
        for(int i : nums){
               temp+=i;
               ans[k++] = temp;
        }
        return ans;
    }
}
