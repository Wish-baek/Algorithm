import java.util.Scanner;

public class Silver9625 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt();

		int a = 1;
		int b = 0;

		for (int i = 0; i < k; i++) {
			int tmpa = a;
			int tmpb = b;
			a = tmpb;
			b = tmpa+tmpb;
			
		}

		System.out.println(a + " " + b);
	}

}
//https://www.acmicpc.net/problem/9625