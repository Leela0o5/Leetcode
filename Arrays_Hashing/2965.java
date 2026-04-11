class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length;
        long N = n*n;
        long expSum = N * (N+1)/2;
        long expSqSum = N * (N+1)*(2*N+1)/6;
        long actSum = 0;
        long actSqSum = 0;
        for(int i = 0;i<n;i++){
            for(int j=0;j<n;j++) {
                actSum += grid[i][j];
                actSqSum +=  (long)grid[i][j] *  grid[i][j];
            }
        }
        long sumDiff = expSum - actSum; // repeated - missing
        long sumSqDiff = expSqSum - actSqSum;

        long sum_ab = sumSqDiff / sumDiff; // repeated + missing

        int missing = (int) (sumDiff + sum_ab)/2;
        int repeated = (int) (sum_ab - sumDiff)/2;

        return new int[]{repeated,missing};





    }
}
