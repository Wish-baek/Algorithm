import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold11779 {

	static List<Node>[] Graph;
	static Object[][] visited; // 0열: 비용, 1열: 도시 개수

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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		Graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			Graph[i] = new ArrayList<>();
		}
		visited = new Object[n + 1][3];
		for (int i = 1; i <= n; i++) {
			visited[i][0] = Integer.MAX_VALUE;
			visited[i][2] = "";
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Graph[a].add(new Node(b, w));
//			Graph[b].add(new Node(a, w));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dfs(start, end);
		System.out.println(visited[end][0]);
		System.out.println(visited[end][1]);
		System.out.println(visited[end][2]);
	}

	static void dfs(int start, int end) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(start, 0));
		visited[start][0] = 0;
		visited[start][1] = 1;
		visited[start][2] += Integer.toString(start) + " ";
		while (!q.isEmpty()) {
			Node node = q.poll();
			if ((int) visited[node.to][0] < node.weight)
				continue;
//			if (node.to == end) {
//				break;
//			}

			for (int i = 0; i < Graph[node.to].size(); i++) {
				Node newNode = Graph[node.to].get(i);
				if ((int) visited[newNode.to][0] > (int) visited[node.to][0] + newNode.weight) {
					visited[newNode.to][0] = (int) visited[node.to][0] + newNode.weight;
					visited[newNode.to][1] = (int) visited[node.to][1] + 1;
					visited[newNode.to][2] = visited[node.to][2]+Integer.toString(newNode.to) + " ";
					q.add(new Node(newNode.to, (int) visited[newNode.to][0]));
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/11779