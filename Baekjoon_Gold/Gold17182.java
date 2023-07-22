import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold17182 {
	static int N, K, result;
	static int[][] adj;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		adj = new int[N][N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adj[i][j] = Math.min(adj[i][j], adj[k][j] + adj[i][k]);
				}
			}
		}

		result = Integer.MAX_VALUE;
		visited[K] = true;
		dfs(K, 0, 0);
		System.out.println(result);
	}

	static void dfs(int now, int depth, int sum) {
		if (depth == N - 1) {
			result = Math.min(result, sum);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, depth + 1, sum + adj[now][i]);
				visited[i] = false;
			}
		}
	}
}

// https://www.acmicpc.net/problem/17182