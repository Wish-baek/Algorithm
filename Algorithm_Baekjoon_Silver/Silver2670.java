import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver2670 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		double[] dp = new double[n];
		for (int i = 0; i < n; i++) {
			dp[i] = Double.parseDouble(br.readLine());
		}

		double max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1] * dp[i]);
			max = Math.max(max, dp[i]);
		}

		System.out.printf("%.3f", max);
	}
}
//https://www.acmicpc.net/problem/2670