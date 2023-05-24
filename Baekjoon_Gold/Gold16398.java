import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold16398 {

	static int N;
	static ArrayList<node>[] graph;

	static class node implements Comparable<node> {
		int to;
		int w;

		public node(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		graph = new ArrayList[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int w = Integer.parseInt(st.nextToken());
				graph[i].add(new node(j, w));
			}
		}
		prim();
	}

	static void prim() {
		PriorityQueue<node> q = new PriorityQueue<>();
		boolean[] visited = new boolean[N];
		q.add(new node(0, 0));

		long sum = 0;

		while (!q.isEmpty()) {
			node node = q.poll();

			if (!visited[node.to]) {

				visited[node.to] = true;
				sum += node.w;

				for (int i = 0; i < graph[node.to].size(); i++) {
					node newNode = graph[node.to].get(i);
					q.add(new node(newNode.to, newNode.w));
				}
			}
		}
		System.out.println(sum);
	}
}
//https://www.acmicpc.net/problem/16398