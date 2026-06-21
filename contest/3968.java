class Solution {
    public static int solve(String s,int x,int y){
        int u=0,l=0,r=0,d=0,k=0;
       for(char ch:s.toCharArray()) {
           if(ch == 'U') u++;
           else if(ch =='D') d++;
           else if(ch == 'L') l++;
           else if(ch == 'R') r++;
           else k++;
       }
        return (int)(Math.abs(r-l) + Math.abs(d-u) + k);
        
    }
    public int maxDistance(String moves) {
        int n = moves.length();
        int x = 0,y=0;
        return solve(moves,x,y);
    }
}
