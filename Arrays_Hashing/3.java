class Solution {
    public int lengthOfLongestSubstring(String s) {
        int r = 0;
        int l = 0;
        HashSet<Character> map = new HashSet<>();
        int maxLen = 0;
        while(r<s.length()){
            if(!map.contains(s.charAt(r))){
                map.add(s.charAt(r));
                maxLen = Math.max(maxLen,r-l+1);
                r++;
            }
            else{
                // Duplicate case
                map.remove(s.charAt(l));
                l++;

            }
        }
        return maxLen;
    }
}
