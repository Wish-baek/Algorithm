import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver14501 {
	static boolean[] visited;
	static int[][] plan;
	static int N, max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		plan = new int[N][2];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int T = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			plan[i][0] = T;
			plan[i][1] = P;
		}

		max = -1;
		dfs(0, 0);
		System.out.println(max);

	}

	static void dfs(int day, int benefit) {
		if (day >= N) {
			max = Math.max(max, benefit);
			return;
		}

		dfs(day + 1, benefit);
		if (day + plan[day][0] <= N)
			dfs(day + plan[day][0], benefit + plan[day][1]);
	}
}
//https://www.acmicpc.net/problem/14501