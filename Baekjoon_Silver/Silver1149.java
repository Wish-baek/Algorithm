import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1149 {
	static int[][] dp, cost;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cost = new int[N][3];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dp = new int[N][3];
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];

		int result = Math.min(paint(N - 1, 0), Math.min(paint(N - 1, 1), paint(N - 1, 2)));
		System.out.println(result);

	}

	static int paint(int n, int color) {
		if (dp[n][color] == 0) {
			if (color == 0)
				dp[n][0] = Math.min(paint(n - 1, 1), paint(n - 1, 2)) + cost[n][0];

			else if (color == 1)
				dp[n][1] = Math.min(paint(n - 1, 0), paint(n - 1, 2)) + cost[n][1];

			else if (color == 2)
				dp[n][2] = Math.min(paint(n - 1, 0), paint(n - 1, 1)) + cost[n][2];
		}

		return dp[n][color];
	}
}
//https://www.acmicpc.net/problem/1149