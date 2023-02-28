import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold12865 {
	static int max_weight;
	static int max_val;
	static int K, N;
	static int[][] info, dp;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		info = new int[N + 1][2];
		dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < K + 1; j++) {
				dp[i][j] = dp[i - 1][j];
				if (j - info[i][0] >= 0)
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - info[i][0]] + info[i][1]);
			}
		}
		System.out.println(dp[N][K]);
	}
}
// https://www.acmicpc.net/problem/12865
