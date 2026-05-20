import java.util.*;

class Solution {
    public boolean isCycleDFS(int src, boolean[] vis, boolean[] recurPath, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        recurPath[src] = true;
        
        for (int v : adj.get(src)) {
            if (!vis[v]) {
                if (isCycleDFS(v, vis, recurPath, adj)) return true;
            } else if (recurPath[v]) {
                return true; // back edge
            }
        }
        
        recurPath[src] = false;
        return false; 
    }


    public void TopoDFS(int src, boolean[] vis, Stack<Integer> st, ArrayList<ArrayList<Integer>> adj) {
        vis[src] = true;
        
        for (int v : adj.get(src)) {
            if (!vis[v]) {
                TopoDFS(v, vis, st, adj);
            }
        }
        st.push(src);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        
        // [a, b] implies dependency b -> a (To take 'a', finish 'b' first)
        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][1]; // Prerequisite
            int v = prerequisites[i][0]; // Next course
            adj.get(u).add(v);
        }


        boolean[] vis = new boolean[numCourses];
        boolean[] recurPath = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (isCycleDFS(i, vis, recurPath, adj)) {
                    return new int[]{}; // Cycle detected
                }
            }
        }


        Stack<Integer> st = new Stack<>();
        Arrays.fill(vis, false); 
        
        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                TopoDFS(i, vis, st, adj);
            }
        }
        
        int[] ans = new int[numCourses];
        int k = 0;
        while (!st.isEmpty()) {
            ans[k++] = st.pop();
        }
        
        return ans;
    }
}
