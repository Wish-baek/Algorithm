import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold10282 {
	static List<Node>[] Graph;
	static int[] visited;
	static int cnt, result;

	static class Node implements Comparable<Node> {
		int to;
		int time;

		public Node(int to, int time) {
			this.to = to;
			this.time = time;
		}

		@Override
		public int compareTo(Node o) {

			return this.time - o.time;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			Graph = new ArrayList[n + 1];
			visited = new int[n + 1];

			for (int i = 1; i <= n; i++) {
				Graph[i] = new ArrayList<>();
				visited[i] = Integer.MAX_VALUE;
			}

			for (int i = 0; i < d; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken());
				Graph[b].add(new Node(a, s));
			}
			hacking(c);
//			for(int i  = 1; i<=n;i++) {
//				System.out.print(visited[i] + " ");
//			}
//			System.out.println();
			System.out.println(cnt + " " + result);

		}

	}

	static void hacking(int s) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(s, 0));
		visited[s] = 0;
		cnt = 0;
		result = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			int now = node.to;
			int time = node.time;
			if (visited[now] < time)
				continue;
			if (visited[now] != Integer.MAX_VALUE)
				cnt++;
			result = Math.max(result, time);

			for (int i = 0; i < Graph[now].size(); i++) {
				Node newNode = Graph[now].get(i);
				if (visited[newNode.to] > visited[now] + newNode.time) {
					visited[newNode.to] = visited[now] + newNode.time;
					q.add(new Node(newNode.to, visited[newNode.to]));

				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/10282