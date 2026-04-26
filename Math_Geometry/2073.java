class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ans = 0;
        int ticketsToBuy = tickets[k];
        for(int i=0;i<tickets.length;i++){
              if(i<=k) ans+=Math.min(ticketsToBuy,tickets[i]);
              else ans+=Math.min(ticketsToBuy-1,tickets[i]);
        }
        return ans;
    }
}
