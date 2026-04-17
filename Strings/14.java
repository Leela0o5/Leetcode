class Solution {
    public String longestCommonPrefix(String[] strs) {
        String base = strs[0];
        int n = strs.length;
        if(n==0) return "";
        for(int i=0;i<base.length();i++){
            for(int j=1;j<n;j++){
                if(base.charAt(i)!=strs[j].charAt(i) || strs[j].length()<=i){
                    return base.substring(0,i);
                }
            }
        }
        return base;
    }
}
