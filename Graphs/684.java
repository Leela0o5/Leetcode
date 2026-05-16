import java.util.ArrayList;

class Solution {
    public boolean dfsHelper(ArrayList<ArrayList<Integer>> adj, boolean vis[], int src, int target, int ans[]) {
        if (src == target) return true;
        
        vis[src] = true;
        for (int v : adj.get(src)) {
            if (!vis[v]) {
                 if (dfsHelper(adj, vis, v, target, ans)) return true;
            }
        }
        return false;
    }

    public int[] findRedundantConnection(int[][] edges) {
        boolean vis[] = new boolean[edges.length + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        
        for (int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }
        
        int ans[] = new int[2];

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            // Reset the visited array for every fresh path search
            for (int j = 0; j <= edges.length; j++) {
                vis[j] = false;
            }

            // If u can already reach v through existing edges, this edge is redundant!
            if (dfsHelper(adj, vis, u, v, ans)) {
                ans[0] = u;
                ans[1] = v;
                return ans; // Return immediately since this is the last problem edge
            }

            // Otherwise, safely add the edge to our growing graph
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        return ans;
    }
}
