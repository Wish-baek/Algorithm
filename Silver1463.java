import java.util.Scanner;

public class Silver1463 {
	static Integer[] dp;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		dp = new Integer[n + 1];
		dp[0] = dp[1] = 0;
		int cnt = 0;
		System.out.println(re(n, cnt));

	}

	static int re(int n, int count) {
		if (n < 2) {
			return count;
		}
		return Math.min(re(n / 2, count + 1 + (n % 2)), re(n / 3, count + 1 + (n % 3)));
	}

}
