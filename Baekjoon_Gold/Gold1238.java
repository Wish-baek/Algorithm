import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold1238 {
	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {

			return this.weight - o.weight;
		}
	}

	static List<Node>[] Graph;
	static int[][] visited, visited2;
	private static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		visited = new int[N + 1][2];
		for (int i = 0; i < N + 1; i++) {
			visited[i][0] = Integer.MAX_VALUE;
		}
		Graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Graph[a].add(new Node(b, w));
		}

		dijkstra(X, 0);

		int max = Integer.MIN_VALUE;

		for (int i = 1; i <= N; i++) {
			for (int a = 1; a <=N; a++) {
				visited[a][1] = Integer.MAX_VALUE;
			}
			dijkstra(i, 1);
			
			max = Math.max(max, visited[i][0] + visited[X][1]);
		}
		System.out.println(max);
//		for (int a = 1; a <= N; a++) {
//			for (int b = 0; b < 2; b++) {
//				System.out.print(visited[a][b] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
	}

	static void dijkstra(int s, int n) {

		PriorityQueue<Node> q = new PriorityQueue<>();
		visited[s][n] = 0;
		q.offer(new Node(s, 0));

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (visited[node.to][n] < node.weight)
				continue;
			for (int i = 0; i < Graph[node.to].size(); i++) {
				Node newNode = Graph[node.to].get(i);
				if (visited[newNode.to][n] > visited[node.to][n] + newNode.weight) {
					visited[newNode.to][n] = visited[node.to][n] + newNode.weight;
					q.offer(new Node(newNode.to, visited[newNode.to][n]));
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/1238