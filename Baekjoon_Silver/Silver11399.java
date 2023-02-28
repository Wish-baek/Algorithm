import java.util.Arrays;
import java.util.Scanner;

public class Silver11399 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		Arrays.sort(arr);

		int sum = arr[0];
		int result = arr[0];

		for (int i = 1; i < n; i++) {
			sum = sum + arr[i];
			result+=sum;
		}
		System.out.println(result);

	}

}
//https://www.acmicpc.net/problem/11399