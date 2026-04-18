class Solution {
    public int[] lpsT(String p){
        int i = 1;
        int len = 0;
        int[] lps = new int[p.length()];
        lps[0] = 0;
        while(i<p.length()){
            if(p.charAt(i) ==p.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len == 0){
                    lps[i] = 0;
                    i++;
                }
                else{
                      len = lps[len-1];
                }
            }
        
        }
        return lps;
    }

    public boolean kmp(String s,String p){
        int i =0;
        int j = 0;
        int m = s.length();
        int n  = p.length();
        int lps[] = lpsT(p);
        while(i<m){
            if(s.charAt(i) == p.charAt(j)){
                i++;
                j++;
            }
            if(j == n){
                j = lps[j-1];
                return true;
            }
            else if(i<m && s.charAt(i) != p.charAt(j)){
                   if(j == 0) i++;   
                   else j = lps[j-1];                     
                }
            }
            return false;
        }
    
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb= new StringBuilder(a);
        int count = 1;
       
        while(sb.length() < b.length()){
            sb.append(a);
            count++;
        }

        if(kmp(sb.toString(),b)) return count;

        sb.append(a);
        if(kmp(sb.toString(),b)) return count+1;
        return -1;
        
    }
}
