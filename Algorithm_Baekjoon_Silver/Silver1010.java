import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Silver1010 {
	static int[][] dp = new int[30][30];

	public static int combination(int n, int r) {
		if (dp[n][r] > 0)
			return dp[n][r];
		if (n == r || r == 0)
			return dp[n][r] = 1;
		else
			return dp[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < 30; i++) {
			dp[i][i] = 1;
		}
		
		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			sb.append(combination(M, N)).append("\n");
		}
		bw.write(sb + "");
		bw.flush();
		bw.close();

	}

}
//https://www.acmicpc.net/problem/1010