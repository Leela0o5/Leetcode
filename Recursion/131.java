class Solution {
    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<=r){
            if(s.charAt(l) == s.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
         return true;
    }
    public void getAllParts(String s,ArrayList<String> partition,List<List<String>> ans){
        if(s.length() == 0) {
            ans.add(new ArrayList<>(partition));
            return;
        }
        for(int i=0;i<s.length();i++){
            String part = s.substring(0,i+1);
            if(isPalindrome(part)){
                partition.add(part);
                 getAllParts(s.substring(i+1),partition,ans);
                 // Backtrack
                 partition.remove(partition.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
           List<List<String>> ans = new ArrayList<>();
           ArrayList<String> partition = new ArrayList<>();
           getAllParts(s,partition,ans);
           return ans;

    }
}
