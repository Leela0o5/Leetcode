class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()){
            return "";
        }
        HashMap<Character,Integer> freqT = new HashMap<>();
         HashMap<Character,Integer> window = new HashMap<>();
        for(char ch:t.toCharArray()){
            freqT.put(ch,freqT.getOrDefault(ch,0)+1);
        }
        int left = 0;
        int right = 0;
        int need  = freqT.size();
        int have = 0;
        int resLen = Integer.MAX_VALUE;
        int[] res = new int[2];

        for(int i=right;i<s.length();i++){
            char currChar = s.charAt(i);
            window.put(currChar,window.getOrDefault(currChar,0)+1);
            if(freqT.containsKey(currChar) && freqT.get(currChar).equals(window.get(currChar))){
                have++;
            }
            while(have == need){
                if(i-left+1<resLen) {resLen = i-left+1;res[0] = left;res[1] = i;}
            char leftChar = s.charAt(left);
            if(freqT.containsKey(leftChar)  && window.get(leftChar).equals(freqT.get(leftChar))) {have--;
            }
            window.put(leftChar,window.get(leftChar)-1);
            left++;
            }
        
    }
    return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);

    }
}
