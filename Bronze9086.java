import java.util.Scanner;

public class Bronze9086 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			System.out.println(str.charAt(0)+ "" +str.charAt(str.length()-1));
		}
	}

}
//https://www.acmicpc.net/problem/9086