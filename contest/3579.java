class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if(need1==0 && need2==0) return 0;
        int maxi = Math.max(need1,need2); // full buy with bundle
        long fullbuy = (long)maxi*(long)costBoth;
        // partial buy
        int minVal = Math.min(need1,need2);
        int needExtra = maxi - minVal;
        int costExtra = (need1>need2 )? cost1 : cost2; 
        long partialBuy = (long)minVal*(long)costBoth + (long)needExtra*(long)costExtra;
        return Math.min((long)cost1*need1+(long)cost2*need2,Math.min(partialBuy,fullbuy));
    }
}
