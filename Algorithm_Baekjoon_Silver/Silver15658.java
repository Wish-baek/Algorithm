import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver15658 {
	static int[] oper, num;
	static int N, max, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		oper = new int[4];
		num = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		dfs(1, num[0]);
		System.out.println(max);
		System.out.println(min);
	}

	static void dfs(int depth, int sum) {
		if (depth == N) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (oper[i] > 0) {
				oper[i]--;
				if (i == 0)
					dfs(depth + 1, sum + num[depth]);
				else if (i == 1)
					dfs(depth + 1, sum - num[depth]);
				else if (i == 2)
					dfs(depth + 1, sum * num[depth]);
				else if (i == 3)
					dfs(depth + 1, sum / num[depth]);
				oper[i]++;
			}
		}
	}
}
//https://www.acmicpc.net/problem/15658