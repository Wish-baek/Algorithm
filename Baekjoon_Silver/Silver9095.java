import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver9095 {
	static int cnt;
	static int[] output;
	static int[] num;
	static int[] arr;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[][] dp = new int[11][2];

		for (int i = 0; i < 11; i++) {
			dp[i][1] = 0;
		}

		int T = Integer.parseInt(br.readLine());
		arr = new int[3];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		for (int tc = 0; tc < T; tc++) {

			n = Integer.parseInt(br.readLine());

			if (dp[n][1] > 0)
				System.out.println(dp[n][1]);
			else {
				cnt = 0;

				for (int i = 1; i <= n; i++) {
					output = new int[i];
					perm(arr, output, 0, i);
				}
				System.out.println(cnt);
			}

		}

	}

	static void perm(int[] arr, int[] output, int depth, int r) {
		if (depth == r) {
			int sum = 0;
			for (int i = 0; i < output.length; i++) {
				sum += output[i];
			}
			if (sum == n)
				cnt++;

			return;
		}

		for (int i = 0; i < arr.length; i++) {
			output[depth] = arr[i];
			perm(arr, output, depth + 1, r);
		}
	}
}
//https://www.acmicpc.net/problem/9095