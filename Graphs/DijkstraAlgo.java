import java.util.*;

class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
          
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int dist[] = new int[V];
        
    
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;
        pq.offer(new int[]{0, src}); // stores {distance, vertex}
        
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int u = top[1];
            
            if (d > dist[u]) continue;
            
            for (int[] p : adj.get(u)) {
                int v = p[0];
                int wt = p[1];
                
                if (dist[u] != Integer.MAX_VALUE && dist[v] > wt + dist[u]) {
                    dist[v] = wt + dist[u];
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }
        
        return dist;
    }
}
