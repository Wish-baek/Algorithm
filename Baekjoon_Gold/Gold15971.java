import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold15971 {
	static ArrayList<Node>[] Graph;
	static int N, a, b;

	static class Node {
		int to;
		int w;

		public Node(int to, int w) {
			this.to = to;
			this.w = w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());

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

		bfs();

	}

	static void bfs() {
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { a, 0, 0 });
		visited[a] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int w = tmp[1];
			int max = tmp[2];

			if (now == b) {
				System.out.println(w - max);
				return;
			}

			for (int i = 0; i < Graph[now].size(); i++) {
				Node node = Graph[now].get(i);
				if (!visited[node.to]) {
					visited[node.to] = true;
					q.add(new int[] { node.to, w + node.w, Math.max(max, node.w) });
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/15971