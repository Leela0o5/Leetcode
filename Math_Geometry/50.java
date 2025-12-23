class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(N<0){
            N=-N;
            x = 1/x;
        }
        if(N==0){
            return 1;
        }
        double temp = myPow(x,(int)(N/2));
        if(N%2 == 0){
            return temp*temp;
        }
      else{
        return x*temp*temp;
      }
        
    }
}