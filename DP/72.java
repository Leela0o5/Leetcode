class Solution {
    public static int helper(String s1, String s2, int i, int j, int[][] dp) {
        // Base cases
        if (i == 0) return j; // Insert all characters of s2
        if (j == 0) return i; // Delete all characters of s1
        
        // Return cached result
        if (dp[i][j] != -1) return dp[i][j];
        
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
            // Match: move both pointers
            return dp[i][j] = helper(s1, s2, i - 1, j - 1, dp);
        } else {
            // Mismatch: find min of Replace, Delete, Insert
            return dp[i][j] = 1 + Math.min(
                helper(s1, s2, i - 1, j - 1, dp), // Replace
                Math.min(helper(s1, s2, i - 1, j, dp), // Delete
                         helper(s1, s2, i, j - 1, dp)) // Insert
            );
        }
    }

    public int minDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
         int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(s1, s2, m, n, dp);
    }    
}
