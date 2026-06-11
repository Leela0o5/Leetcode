class Solution {
    public static int helper(int n, int amt, int dp[][], int c[]) {
    if (amt == 0) return 1;
    if (n < 0 || amt < 0) return 0;
    if (dp[n][amt] != -1) return dp[n][amt];
    int pick = helper(n, amt - c[n], dp, c);
    int nonPick = helper(n - 1, amt, dp, c);
    return dp[n][amt] = pick + nonPick;
}
    public int change(int amt, int[] c) {
        int n=c.length;
        int dp[][] = new int[n][amt + 1];
    for (int[] row : dp) Arrays.fill(row, -1);
    return helper(n - 1, amt,dp,c);
    }
}
