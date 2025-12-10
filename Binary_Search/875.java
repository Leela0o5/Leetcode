package Binary_Search;

class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int maxPiles = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxPiles = Math.max(maxPiles, pile);
        }
        int r = maxPiles;
        int res = r;
        while (l <= r) {
            // K is the speed
            int k = (l + r) / 2;
            long TotalTime = 0;
            for (int pile : piles) {
                TotalTime += Math.ceil((double) pile / k);
            }
            if (TotalTime <= h) {
                res = k;
                r = k - 1;
            } else {
                // More time to eat means slow speed. So, we have to increase the speed.
                l = k + 1;
            }
        }
        return res;
    }
}