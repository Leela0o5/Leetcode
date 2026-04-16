class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character,Integer> m1 = new HashMap<>();
         HashMap<Character,Integer> m2 = new HashMap<>();
         if(s.length()!=t.length()) return false;
         for(int i=0;i<s.length();i++){
            m1.put(s.charAt(i),m1.getOrDefault(s.charAt(i),0)+1);
            m2.put(t.charAt(i),m2.getOrDefault(t.charAt(i),0)+1);
         }
         return m1.equals(m2);
    }
}