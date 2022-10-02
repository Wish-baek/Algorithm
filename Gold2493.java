import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold2493 {

	static class Point {
		int num;
		int height;

		public Point(int num, int height) {
			this.num = num;
			this.height = height;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		Stack<Point> stack = new Stack<>();

		for (int i = 1; i <= N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (stack.isEmpty())
				sb.append("0").append(" ");
			else {
				if (stack.peek().height < n) {

					while (true) {
						if (stack.isEmpty()) {
							sb.append("0").append(" ");
							break;
						}
						if (stack.peek().height >= n) {
							sb.append(stack.peek().num).append(" ");
							break;
						}
						stack.pop();
					}

				} else if (stack.peek().height >= n)
					sb.append(stack.peek().num).append(" ");
			}
			stack.add(new Point(i, n));
		}
		System.out.println(sb);
	}
}
//https://www.acmicpc.net/problem/2493