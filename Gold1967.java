import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold1967 {
	static List<Node>[] Graph;
	static boolean[] visited;
	static int max, n;

	static class Node {
		int to;
		int dist;

		public Node(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		Graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			Graph[a].add(new Node(b, s));
			Graph[b].add(new Node(a, s));
		}

		for (int i = 1; i <= n; i++) {
			visited = new boolean[n + 1];
			visited[i] = true;
			maxDist(i, 0);
		}

		System.out.println(max);

	}

	static void maxDist(int s, int sum) {
		max = Math.max(max, sum);

		for (int i = 0; i < Graph[s].size(); i++) {
			Node newNode = Graph[s].get(i);
			if (!visited[newNode.to]) {
				visited[newNode.to] = true;
				maxDist(newNode.to, sum + newNode.dist);
			}
		}
	}
}
//https://www.acmicpc.net/problem/1967