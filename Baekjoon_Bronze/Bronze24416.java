import java.util.Scanner;

public class Bronze24416 {
	static int cnt = 0;
	static int cnt2 = 0;
	static int[] f;

	static int Recur_fib(int n) {
		
		if (n == 1 || n == 2) {
			cnt++;
			return 1;
		} else
			return (Recur_fib(n - 1) + Recur_fib(n - 2));
	}

	static int Dynamic_fib(int n) {
		
		f[1] = f[2] = 1;
		for(int i = 3; i <=n; i++) {
			cnt2++;
			f[i] = f[i-1]+f[i-2];
		}
		
		return f[n];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		f = new int[n + 1];
		Recur_fib(n);
		Dynamic_fib(n);
		System.out.println(cnt + " " + cnt2);
	}

}
//https://www.acmicpc.net/problem/24416