class  fibonacci_DP_Approach{
   public static int memoization(int n,int[] fib) {
     if(n<0) return 0;
     if(n==0 || n==1) return n;
     if(fib[n]!=-1) return fib[n];
     return fib[n] = memoization(n-1,fib) + memoization(n-2,fib);
     
   }

  public static int tabulation(int n){
      int dp[] = new int[n];
      dp[0] = 0;
      dp[1] = 1;
      for(int i=2;i<=n;i++){
        dp[i] = dp[i-1] + dp[i-2];
       }
    return dp[n-1];
   }

}
