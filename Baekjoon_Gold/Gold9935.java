import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Gold9935 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String str2 = br.readLine();
		int len = str2.length();
		Stack<Character> stack = new Stack<>();

		for (int s = 0; s < str.length(); s++) {
			stack.add(str.charAt(s));

			if (stack.size() >= len) {
				boolean isSame = true;

				for (int i = 0; i < len; i++) {
					if (stack.get(stack.size() - i - 1) != str2.charAt(len - i - 1)) {
						isSame = false;
						break;
					}
				}

				if (isSame) {
					for (int i = 0; i < len; i++)
						stack.pop();
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		if (stack.isEmpty())
			System.out.println("FRULA");
		else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
			System.out.println(sb);
		}

	}
}
//https://www.acmicpc.net/problem/9935