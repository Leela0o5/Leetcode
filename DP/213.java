import java.util.Arrays;

class Solution {
    public int helper(int[] a, int dp[], int idx) {
        if (idx == 0) return a[0];
        if (idx < 0) return 0;
        
        if (dp[idx] != -1) return dp[idx];
        
        int pick = a[idx] + helper(a, dp, idx - 2);
        int nonPick = helper(a, dp, idx - 1);
        
        return dp[idx] = Math.max(pick, nonPick);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] temp1 = new int[nums.length - 1];
        int[] temp2 = new int[nums.length - 1];
        int k1 = 0, k2 = 0;
        
    
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) temp1[k1++] = nums[i];               
            if (i != nums.length - 1) temp2[k2++] = nums[i]; 
        }
        int dp[] = new int[nums.length - 1];
        Arrays.fill(dp, -1);
        int ans1 = helper(temp1, dp, temp1.length - 1); 

        Arrays.fill(dp, -1);
        int ans2 = helper(temp2, dp, temp2.length - 1); 

        return Math.max(ans1, ans2);
    }
}
