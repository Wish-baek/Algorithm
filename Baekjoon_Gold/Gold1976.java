import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold1976 {
	static int[][] adj;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		adj = new int[N + 1][N + 1];

		StringTokenizer st;

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				adj[i][j] = Integer.parseInt(st.nextToken());
				if (i == j)
					adj[i][j] = 1;
			}
		}

		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (adj[i][k] == 1 && adj[k][j] == 1) {
						adj[i][j] = 1;
					}
				}
			}
		}

		boolean result = true;

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M - 1; i++) {
			int b = Integer.parseInt(st.nextToken());
			if (adj[a][b] == 0) {
				result = false;
				break;
			}
			a = b;
		}
		System.out.println(result ? "YES" : "NO");
	}
}

//https://www.acmicpc.net/problem/1976