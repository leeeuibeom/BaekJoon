import java.util.*;

public class Main {

    static final int INF = 1000000000; // INF 값 설정 (최대값)

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점 개수
        int E = sc.nextInt(); // 간선 개수
        int start = sc.nextInt(); // 시작 정점 (1-based index)

        // 그래프 초기화
        ArrayList<Edge>[] graph = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 간선 입력 받기
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Edge(v, w));
        }

        // 다익스트라 알고리즘
        int[] dist = new int[V + 1]; // 거리 배열
        Arrays.fill(dist, INF); // 초기 값은 INF로 설정
        dist[start] = 0;

        // 우선순위 큐 (거리, 정점)
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;

            if (dist[node] < cost) continue; // 이미 더 적은 비용으로 방문한 경우

            for (Edge next : graph[node]) {
                int newDist = cost + next.cost;
                if (newDist < dist[next.node]) {
                    dist[next.node] = newDist;
                    pq.offer(new Edge(next.node, newDist));
                }
            }
        }

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    // 간선 정보 클래스
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
