import java.util.Scanner;
import java.util.Stack;

public class Silver9012 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {

			Stack<Character> stack = new Stack<>();
			String str = sc.next();

			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);

				if (c == ')' && !stack.isEmpty() && stack.peek() == '(')
					stack.pop();
				else
					stack.push(c);

			}

			if (stack.size() == 0)
				System.out.println("YES");
			else
				System.out.println("NO");

		}

	}

}
//https://www.acmicpc.net/problem/9012
