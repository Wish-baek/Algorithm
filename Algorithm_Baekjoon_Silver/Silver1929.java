import java.util.Scanner;

public class Silver1929 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int M = sc.nextInt();
		int N = sc.nextInt();

		int[] arr = new int[N + 1];

		for (int i = 2; i <= N; i++) {
			arr[i] = i;
		}
		for (int i = 2; i <= N; i++) {
			if (arr[i] == 0)
				continue;
			for (int j = 2 * i; j <= N; j += i) {
				arr[j] = 0;
			}
		}
		int cnt = 0;
		for (int i = M; i <= N; i++) {
			if (arr[i] != 0) sb.append(i).append("\n");
		}
		System.out.println(sb);

	}

}
//https://www.acmicpc.net/problem/1929