class Solution {
    public boolean SameFreqArr(int[] windFreq,int[] freq){
        for(int i=0;i<26;i++){
            if(freq[i]!=windFreq[i]) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
        }
        int windowSize = s1.length();
        for(int i=0;i<s2.length();i++){
            int windIdx =0;
            int windFreq[] = new int[26];
            int idx = i;
            while(windIdx<windowSize && idx<s2.length()){
                windFreq[s2.charAt(idx)-'a']++;
                windIdx++;
                idx++;
            }
            if(SameFreqArr(windFreq,freq)) return true;
        }
        return false;
    }
}
