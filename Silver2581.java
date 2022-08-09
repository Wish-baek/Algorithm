import java.util.Scanner;

public class Silver2581 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int m = sc.nextInt();
		int n = sc.nextInt();

		int sum = 0;
		int min = 10000;
		for (int i = m; i <= n; i++) {
			boolean ck = true;
			if (i == 1)
				ck = false;
			else {
				for (int j = 2; j < i; j++) {
					if (i % j == 0)
						ck = false;
				}
			}
			if (ck == true) {
				sum += i;
				if (i < min)
					min = i;
			}

		}

		if (sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
//https://www.acmicpc.net/problem/2581