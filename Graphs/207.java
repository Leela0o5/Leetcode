import java.util.*;

class Solution {

    public boolean bfsHelper(List<List<Integer>> adj, boolean visited[], int indegree[]) {

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < visited.length; i++) {

            if(indegree[i] == 0) {

                q.add(i);

                visited[i] = true;
            }
        }

        int count = 0;

        while(q.size() > 0) {

            int u = q.remove();

            count++;

            for(int v : adj.get(u)) {

                indegree[v]--;

                if(indegree[v] == 0 && !visited[v]) {

                    q.add(v);

                    visited[v] = true;
                }
            }
        }

        return count == visited.length;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean vis[] = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            vis[i] = false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[numCourses];

        for(int i = 0; i < prerequisites.length; i++) {

            int u = prerequisites[i][1];
            int v = prerequisites[i][0];

            adj.get(u).add(v);

            indegree[v]++;
        }

        return bfsHelper(adj, vis, indegree);
    }
}
