import java.util.Scanner;

public class Silver11047 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int total = sc.nextInt();
		int cnt = 0;

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = n - 1; i >= 0; i--) {

			cnt+= total/arr[i];
			total%=arr[i];
			
		}
		System.out.println(cnt);

	}

}
//https://www.acmicpc.net/problem/11047