import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze2748 {
	static long[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dp = new long[91];

		int n = Integer.parseInt(br.readLine());

		dp[1] = 1;
		System.out.println(fibo(n));
	}

	static long fibo(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;
		else if (dp[n] > 0)
			return dp[n];
		else
			return dp[n] = fibo(n - 1) + fibo(n - 2);
	}
}
//https://www.acmicpc.net/problem/2748