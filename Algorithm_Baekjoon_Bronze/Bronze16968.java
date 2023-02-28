import java.util.Scanner;

public class Bronze16968 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		int[] arr = new int[str.length()];

		if (str.charAt(0) == 'c')
			arr[0] = 26;
		else if (str.charAt(0) == 'd')
			arr[0] = 10;

		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == 'd' && str.charAt(i) == 'd')
				arr[i] = 9;

			else if (str.charAt(i - 1) == 'c' && str.charAt(i) == 'c')
				arr[i] = 25;
			else if (str.charAt(i) == 'd')
				arr[i] = 10;
			else if (str.charAt(i) == 'c')
				arr[i] = 26;
		}
		int sum = 1;

		for (int i = 0; i < str.length(); i++) {
			sum *= arr[i];
		}
		System.out.println(sum);
	}
}
//https://www.acmicpc.net/problem/16968