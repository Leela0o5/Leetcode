class Solution {
    public int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        for(char ch:chars){
            s.append(ch);
        }
        StringBuilder res = new StringBuilder();
        int count=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                    count++;
            }
            else{
                res.append(s.charAt(i-1));
                if(count>1) res.append(count);
                count=1;
            }
        }

        res.append(s.charAt(s.length()-1));
        if(count>1) res.append(count);
        String compressed = res.toString();
        for(int i = 0;i<compressed.length();i++){
                chars[i] = compressed.charAt(i);
            }
        return compressed.length();

    }
    
}
