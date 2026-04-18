class Solution {
    public String longestPrefix(String s) {
        int lps[] = new int[s.length()];
        int i  = 1;
        int len = 0;
        lps[0] = 0;
        while(i<s.length()){
            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len == 0) {lps[i] = 0; i++;}
                else len = lps[len-1];
            }
        }

        return s.substring(0,lps[s.length()-1]);
    }
}
