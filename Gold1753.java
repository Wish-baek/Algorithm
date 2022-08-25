import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold1753 {
	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Gold1753.Node o) {

			return this.weight - o.weight;
		}
	}

	static List<Node>[] Graph;
	static int[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());

		Graph = new ArrayList[V + 1];
		visited = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			visited[i] = Integer.MAX_VALUE;
		}

		for (int i = 1; i <= V; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {

			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			Graph[a].add(new Node(b, w));
		}

		dijkstra(K);
		for (int i = 1; i < V + 1; i++) {
			if (visited[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(visited[i]);
		}
	}

	static void dijkstra(int s) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(s, 0));
		visited[s] = 0;
		while (!pq.isEmpty()) {

			Node node = pq.poll();

			if (visited[node.to] < node.weight) {
				continue;

			}
			for (int i = 0; i < Graph[node.to].size(); i++) {
				Node newNode = Graph[node.to].get(i);

				if (visited[newNode.to] > visited[node.to] + Graph[node.to].get(i).weight) {
					visited[newNode.to] = visited[node.to] + Graph[node.to].get(i).weight;
					pq.add(new Node(newNode.to, visited[newNode.to]));
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/1753