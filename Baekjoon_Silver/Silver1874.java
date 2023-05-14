import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Silver1874 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		Stack<Integer> stack = new Stack<>();

		int[] arr = new int[n + 1];
		int now = 1;
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {

			stack.push(i);
			sb.append("+").append("\n");

			while (!stack.isEmpty() && stack.peek() == arr[now]) {
				stack.pop();
				sb.append("-").append("\n");
				now++;
			}
		}

		if (stack.isEmpty())
			System.out.println(sb);
		else
			System.out.println("NO");

	}
}
//https://www.acmicpc.net/problem/1874