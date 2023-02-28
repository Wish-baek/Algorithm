import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold1922 {

	static List<Node>[] Graph;
	static boolean[] visited;

	static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Gold1922.Node o) {

			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		visited = new boolean[N + 1];

		Graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Graph[a].add(new Node(b, w));
			Graph[b].add(new Node(a, w));
		}
		System.out.println(connect());
	}

	static int connect() {

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(1, 0));

		int res = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (!visited[node.to]) {
				visited[node.to] = true;
				res += node.weight;

				for (int i = 0; i < Graph[node.to].size(); i++) {
					Node newNode = Graph[node.to].get(i);
					q.add(new Node(newNode.to, newNode.weight));
				}
			}
		}
		return res;
	}
}
//https://www.acmicpc.net/problem/1922