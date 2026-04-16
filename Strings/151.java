class Solution {
    public String reverseWords(String s) {
        s=s.trim();
        int left= s.length()-1;
        String res = "";
        while(left>=0){
            while(left>=0 && s.charAt(left)==' '){
                left--;
            }
            int right = left; // Mark the end of the word
            while(left>=0 && s.charAt(left)!=' '){
                left--;
            }
            if(res.equals("")){
                res = s.substring(left+1,right+1);
            }
            else{
                res = res+" "+ s.substring(left+1,right+1);
            }

        } 
        return res;
    }
}
