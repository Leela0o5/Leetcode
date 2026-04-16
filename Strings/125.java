class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int st = 0;
        int e = s.length()-1;
        while(st<e){
            while(st<e && !Character.isLetterOrDigit(s.charAt(st))) st++;
            while(st<e && !Character.isLetterOrDigit(s.charAt(e))) e--;
            
            if(s.charAt(st) == s.charAt(e)) {
                st++;
                e--;
            }else return false;

        }

        return true;
    }
}
