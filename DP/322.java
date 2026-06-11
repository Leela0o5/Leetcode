class Solution {
    public static int helper(int n, int amt, int c[], int dp[][]) {
    if (amt == 0) return 0; 
    if (amt < 0 || n < 0) return 10001; 
    if (dp[n][amt] != -1) return dp[n][amt]; 
    
    int pick = 10001; 
    if (c[n] <= amt) {
        pick = 1 + helper(n, amt - c[n], c, dp); 
    } 
    int nonPick = helper(n - 1, amt, c, dp); 
    return dp[n][amt] = Math.min(pick, nonPick); 
}
public int coinChange(int[] c, int amt) {
    int n = c.length;
    int dp[][] = new int[n][amt + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    int res = helper(n - 1, amt, c, dp);
    return res >= 10001 ? -1 : res;
    }
}
