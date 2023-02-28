import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold2023 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		dfs(0, n);
	}

	static void dfs(int num, int n) {
		if (n == 0)
			System.out.println(num);
		for (int i = 1; i < 10; i++) {
			int tmp = 10 * num + i;
			if (isPrime(tmp)) {
				dfs(tmp, n - 1);
			}
		}
	}

	static boolean isPrime(int n) {
		if (n == 1)
			return false;

		int s = (int) Math.sqrt(n);
		for (int i = 2; i <= s; i++) {
			if (n % i == 0)
				return false;
		}
		return true;

	}

}
//https://www.acmicpc.net/problem/2023