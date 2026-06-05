import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] edges, int src, int dest, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v, w});
        }

        int dist[] = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // {currentNode, currentCost, currentStops}
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{src, 0, 0}); 

        while (!q.isEmpty()) {
            int[] top = q.poll();
            int u = top[0];
            int cost = top[1];
            int stops = top[2];

            if (stops > k) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                if (cost + weight < dist[v]) {
                    dist[v] = cost + weight;
                    q.add(new int[]{v, dist[v], stops + 1});
                }
            }
        }


        return dist[dest] == Integer.MAX_VALUE ? -1 : dist[dest];
    }
}
