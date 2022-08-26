import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver9205 {
	static List<Integer>[] Graph;
	static boolean[] visited;
	private static Silver9205.Node[] node;
	static int n;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < t; tc++) {
			n = Integer.parseInt(br.readLine());
			node = new Node[n + 2];

			for (int i = 0; i < n + 2; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				node[i] = new Node(x, y);
			}

			Graph = new ArrayList[n + 2];
			visited = new boolean[n + 2];

			for (int i = 0; i < n + 2; i++) {
				Graph[i] = new ArrayList<>();
			}

			for (int i = 0; i < n + 2; i++) {
				for (int j = i + 1; j < n + 2; j++) {
					if (Math.abs(node[i].c - node[j].c) + Math.abs(node[i].r - node[j].r) <= 1000) {
						Graph[i].add(j);
						Graph[j].add(i);
					}
				}
			}
			System.out.println(bfs());

		}
	}

	static String bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = true;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			if (tmp == n + 1)
				return "happy";

			for (int i = 0; i < Graph[tmp].size(); i++) {
				int next = Graph[tmp].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
				}
			}
		}
		return "sad";
	}

}
