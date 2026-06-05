import java.util.ArrayList;
import java.util.Stack;

class Solution {
    public void dfs(int u, int[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[u] = 1;
        for (int v : adj.get(u)) {
            if (vis[v] == 0) {
                dfs(v, vis, st, adj);
            }
        }
        st.push(u);
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) { 
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0]; 
            int v = edges[i][1];
            adj.get(u).add(v);
        }
        
        int[] vis = new int[V]; 
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, st, adj);
            }
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        while (!st.isEmpty()) {
            ans.add(st.pop());
        }
        
        return ans;
    }
}
