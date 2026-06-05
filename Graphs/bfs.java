class Solution {
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] =  true;
        while(q.size()>0){
            int u=q.remove();
            ans.add(u);
            for(int v:adj.get(u)){
                if(!visited[v]){
                     visited[v] = true;
                     q.add(v);
                }
            }
        }
        
        return ans;
        
        
    }
}
