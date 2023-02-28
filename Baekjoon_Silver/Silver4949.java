import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver4949 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			String str = br.readLine();
			if (str.equals("."))
				break;

			Stack<Character> stack = new Stack<>();
			String result = "yes";

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(')
					stack.add('(');

				else if (str.charAt(i) == '[')
					stack.add('[');

				else if (str.charAt(i) == ')') {
					if (!stack.isEmpty() && stack.peek() == '(') {
						stack.pop();
					} else {
						result = "no";
						break;
					}
				}

				else if (str.charAt(i) == ']') {
					if (!stack.isEmpty() && stack.peek() == '[') {
						stack.pop();
					} else {
						result = "no";
						break;
					}
				}

			}
			if (stack.isEmpty() &&result.equals("yes"))
				result = "yes";

			else
				result = "no";
			System.out.println(result);
		}
	}
}
//https://www.acmicpc.net/problem/4949