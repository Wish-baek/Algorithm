import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1240 {
	static List<Node>[] Graph;
	static int[] visited;
	static int N;

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
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Graph[a].add(new Node(b, w));
			Graph[b].add(new Node(a, w));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			System.out.println(bfs(start, end) - 1);

		}
	}

	static int bfs(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		visited = new int[N + 1];
		Arrays.fill(visited, 987654321);
		visited[start] = 1;

		while (!q.isEmpty()) {
			Node node = q.poll();
			int now = node.to;
			int w = node.weight;
			for (int i = 0; i < Graph[now].size(); i++) {
				Node newNode = Graph[now].get(i);
				if (visited[newNode.to] > visited[now] + newNode.weight) {
					visited[newNode.to] = visited[now] + newNode.weight;
					q.add(new Node(newNode.to, visited[newNode.to]));
				}
			}
		}
		return visited[end];
	}

}
//https://www.acmicpc.net/problem/1240