import java.util.Scanner;

public class Silver15650 {
	static int N, R;
	static int tmp =1;
	static int[] numbers;
	static boolean[] isSelected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();

		numbers = new int[R];

		isSelected = new boolean[N + 1];

		perm(1, 0);
	}

	public static void perm(int at, int cnt) {

		if (cnt == R) {
			for (int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = at; i <= N; i++) {
				numbers[cnt] = i;
				perm(i+1, cnt + 1);
			}
		
	}
}
//https://www.acmicpc.net/problem/15650