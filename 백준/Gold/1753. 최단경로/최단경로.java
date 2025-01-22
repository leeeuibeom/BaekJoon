import java.util.*;

public class Main {

    static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();

    
        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
        }

        
        int[] dist = new int[V + 1]; 
        Arrays.fill(dist, INF); 
        dist[start] = 0;

        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;

            if (dist[node] < cost) continue; 

            for (Edge next : graph[node]) {
                int newDist = cost + next.cost;
                if (newDist < dist[next.node]) {
                    dist[next.node] = newDist;
                    pq.offer(new Edge(next.node, newDist));
                }
            }
        }

       
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }


    static class Edge implements Comparable<Edge> {
        int node;
        int cost;

        public Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
