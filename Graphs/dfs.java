class Solution {
    public void dfsHelper(int u,ArrayList<ArrayList<Integer>> adj,boolean visited[],ArrayList<Integer> ans){
        ans.add(u);
        visited[u] = true;
        for(int v:adj.get(u)){
            if(!visited[v]){
                dfsHelper(v,adj,visited,ans);
            }
        }
        
    }
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] visited = new boolean[adj.size()];
        ArrayList<Integer> ans = new ArrayList<>();
        
        dfsHelper(0, adj, visited, ans);
        return ans;
        
    }
}