import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver2579 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int[] dp = new int[N + 1];
		int[] stair = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			stair[i] = Integer.parseInt(br.readLine());
		}

		dp[1] = stair[1];

		for (int i = 2; i <= N; i++) {
			if (i == 2)
				dp[2] = stair[1] + stair[2];

			else if (i == 3)
				dp[3] = Math.max(stair[1], stair[2]) + stair[3];
			else
				dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];
		}
		System.out.println(dp[N]);
	}
}
//https://www.acmicpc.net/problem/2579