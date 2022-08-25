import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver10971 {
	static int[][] map;

	static int min, N;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		int[] output = new int[N];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		min = Integer.MAX_VALUE;
		dfs(output, 0);
		System.out.println(min);

	}

	static void dfs(int[] output, int depth) {
		if (depth == N) {

			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += map[output[i]][output[i + 1]];
				if (map[output[i]][output[i + 1]] == 0)
					return;
			}
			sum += map[output[N - 1]][output[0]];
			if (map[output[N - 1]][output[0]] == 0)
				return;
			if (sum < min) {
				min = sum;
//				System.out.println(Arrays.toString(output));
			}
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = i;
				dfs(output, depth + 1);
				visited[i] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/10971