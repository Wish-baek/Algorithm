import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Silver1094 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[] arr = { 64, 32, 16, 8, 4, 2, 1 };

		int count = 0;

		for (int i = 0; i < arr.length; i++) {

			if (n == 0)
				break;

			if (n < arr[i])
				continue;
			else if (n >= arr[i]) {
				n -= arr[i];
				count++;
			}
		}
		System.out.println(count);
	}

}
