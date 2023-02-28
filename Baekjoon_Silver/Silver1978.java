import java.util.Scanner;

public class Silver1978 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int cnt = 0;

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			boolean ck = true;

			if (num == 1)
				ck = false;
			else {
				for (int j = 2; j < num; j++) {
					if (num % j == 0)
						ck = false;
				}
				if (ck == true)
					cnt++;
			}
		}
		System.out.println(cnt);
	}
}
//https://www.acmicpc.net/problem/1978