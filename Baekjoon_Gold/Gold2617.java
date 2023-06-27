import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold2617 {
	static boolean[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		adj = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					adj[i][j] = true;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adj[a][b] = true;
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (adj[i][k] && adj[k][j])
						adj[i][j] = true;
				}
			}
		}

		int[] small = new int[N + 1];
		int[] big = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i == j)
					continue;
				if (adj[i][j])
					small[i]++;
				if (adj[j][i])
					big[i]++;
			}
		}

		int result = 0;

		for (int i = 1; i <= N; i++) {
			if (small[i] >= (N + 1) / 2 || big[i] >= (N + 1) / 2)
				result++;
		}

		System.out.println(result);
	}
}

// https://www.acmicpc.net/problem/2617