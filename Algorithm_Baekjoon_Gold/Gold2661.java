import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold2661 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dfs(0, "");
	}

	static void dfs(int depth, String sum) {
		if (depth == N) {
			System.out.println(sum);
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			if (isPossible(sum + Integer.toString(i))) {
				dfs(depth + 1, sum + Integer.toString(i));
			}
		}
	}

	static boolean isPossible(String num) {
		int len = num.length() / 2;

		for (int i = 1; i <= len; i++) {
			if (num.substring(num.length() - i).equals(num.substring(num.length() - 2 * i, num.length() - i))) {
				return false;
			}
		}
		return true;
	}
}
//https://www.acmicpc.net/problem/2661