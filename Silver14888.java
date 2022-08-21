import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver14888 {
	static int max, min, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());

		int[] num = new int[N];
		int[] oper = new int[4]; // 덧셈+, 뺄셈-, 곱셈*, 나눗셈/

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}

		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(1, num[0], oper, num);
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}

	static void dfs(int s, int sum, int[] oper, int[] num) {
		if (s == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {

			if (oper[i] != 0) {

				oper[i]--;

				if (i == 0)
					dfs(s + 1, sum + num[s], oper, num);
				else if (i == 1)
					dfs(s + 1, sum - num[s], oper, num);
				else if (i == 2)
					dfs(s + 1, sum * num[s], oper, num);
				else if (i == 3)
					dfs(s + 1, sum / num[s], oper, num);

				oper[i]++;
			}
		}
	}
}
//https://www.acmicpc.net/problem/14888