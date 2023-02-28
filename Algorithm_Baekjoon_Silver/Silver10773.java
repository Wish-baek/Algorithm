import java.util.Scanner;
import java.util.Stack;

public class Silver10773 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			if (a != 0)
				stack.push(a);
			else
				stack.pop();
		}

		int sum = 0;
		for (int i : stack) {
			sum += i;
		}
		System.out.println(sum);
	}

}
//https://www.acmicpc.net/problem/10773
