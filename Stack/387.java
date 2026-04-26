class Solution {
    public int firstUniqChar(String s) {
        Queue<Integer> q = new LinkedList<>();
        int freq[] = new int[26];
        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);
            freq[curr-'a']++;
            q.offer(i);
            while(!q.isEmpty() && freq[s.charAt(q.peek())-'a'] >1){
                q.poll();
            }
        }

        return q.isEmpty()?-1:q.peek();
    }
}
