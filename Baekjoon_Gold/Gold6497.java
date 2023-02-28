import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold6497 {
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
		public int compareTo(Node o) {

			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			if (m == 0 && n == 0)
				break;
			Graph = new ArrayList[m + 1];
			visited = new boolean[m + 1];

			for (int i = 0; i <= m; i++) {
				Graph[i] = new ArrayList<>();
			}
			int sum = 0;

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());
				Graph[x].add(new Node(y, z));
				Graph[y].add(new Node(x, z));
				sum += z;
			}

			System.out.println(sum - lampCnt());
		}

	}

	static int lampCnt() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0));
		int res = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (!visited[node.to]) {
				res += node.weight;
				visited[node.to] = true;
				for (int i = 0; i < Graph[node.to].size(); i++) {
					Node newNode = Graph[node.to].get(i);
					q.add(new Node(newNode.to, newNode.weight));

				}
			}
		}
		return res;
	}

}
//https://www.acmicpc.net/problem/6497