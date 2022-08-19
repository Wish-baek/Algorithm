import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1260 {
	static int N, M, V;
	static int[][] node;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		node = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			node[from][to] = 1;
			node[to][from] = 1;
		}

		dfs(V);
		System.out.println();
		bfs();
	}

	static void dfs(int n) {
		visited[n] = true;
		System.out.print(n + " ");
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && node[n][i] != 0) {
				visited[i] = true;
				dfs(i);
			}
		}
	}

	static void bfs() {
		visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(V);
		visited[V] = true;

		while (!q.isEmpty()) {
			int tmp = q.poll();
			System.out.print(tmp + " ");
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && node[tmp][i] != 0) {
					visited[i] = true;
					q.offer(i);
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/1260