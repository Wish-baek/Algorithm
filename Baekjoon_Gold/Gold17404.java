import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold17404 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] color = new int[n][3];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] result = new int[3];

		int[][] dp = new int[n][3];
		for (int i = 0; i < 3; i++) {
			dp[0][0] = 1001;
			dp[0][1] = 1001;
			dp[0][2] = 1001;

			dp[0][i] = color[0][i];

			for (int k = 1; k < n; k++) {
				dp[k][0] = Math.min(dp[k - 1][1], dp[k - 1][2]) + color[k][0];
				dp[k][1] = Math.min(dp[k - 1][0], dp[k - 1][2]) + color[k][1];
				dp[k][2] = Math.min(dp[k - 1][0], dp[k - 1][1]) + color[k][2];
			}

			if (i == 0)
				result[i] = Math.min(dp[n - 1][1], dp[n - 1][2]);
			if (i == 1)
				result[i] = Math.min(dp[n - 1][0], dp[n - 1][2]);
			if (i == 2)
				result[i] = Math.min(dp[n - 1][0], dp[n - 1][1]);
		}
		System.out.println(Math.min(result[0], Math.min(result[1], result[2])));
	}
}
//https://www.acmicpc.net/problem/17404
