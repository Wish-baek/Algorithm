import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze9506 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == -1)
				break;
			int sum = 0;
			sb = new StringBuilder();

			for (int i = 1; i < n; i++) {
				if (n % i == 0) {
					if (sb.length() != 0)
						sb.append("+").append(" ");
					sum += i;
					sb.append(i).append(" ");

				}
			}
			if (sum == n) {
				System.out.print(n + " = ");
				System.out.println(sb);
			} else
				System.out.println(n + " is NOT perfect.");
		}
	}
}
//https://www.acmicpc.net/problem/9506