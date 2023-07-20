import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold1956 {
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		adj = new int[V + 1][V + 1];

		int n = 987654321;

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j)
					continue;
				adj[i][j] = n;
			}
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			adj[a][b] = c;
		}

		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[i][k] + adj[k][j]);
				}
			}
		}

		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j)
					continue;
				if (adj[i][j] != n && adj[j][i] != n) {
					min = Math.min(min, adj[i][j] + adj[j][i]);
				}
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

}

// https://www.acmicpc.net/problem/1956