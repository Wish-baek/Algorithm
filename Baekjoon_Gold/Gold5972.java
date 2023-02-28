import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold5972 {
	static List<Node>[] Graph;
	static int[] visited;

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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited[i] = Integer.MAX_VALUE;
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
			Graph[b].add(new Node(a, w));
		}
		route();
		System.out.println(visited[N]);

	}

	static void route() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(1, 0));
		visited[1] = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (visited[node.to] < node.weight)
				continue;
			for (int i = 0; i < Graph[node.to].size(); i++) {
				Node newNode = Graph[node.to].get(i);
				if (visited[newNode.to] > visited[node.to] + newNode.weight) {
					visited[newNode.to] = visited[node.to] + newNode.weight;
					q.add(new Node(newNode.to, visited[newNode.to]));
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/5972