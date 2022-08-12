import java.util.Arrays;
import java.util.Scanner;

public class Bronze2851 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int[] arr = new int[10];

		int s = 0;
		int[] sum = new int[12];

		for (int i = 0; i < 10; i++) {
			arr[i] = sc.nextInt();
			s += arr[i];
			sum[i] = s;

		}

		int min_abs = 1000000;
		int max = -1;

		for (int i = 0; i < 10; i++) {
			if (Math.abs(sum[i] - 100) <= min_abs) {
				min_abs = Math.abs(sum[i] - 100);
				max = sum[i];
			}
		}
		System.out.println(max);

	}
}
//https://www.acmicpc.net/problem/2851