import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver14620 {
	static int[][] map;
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		min = Integer.MAX_VALUE;

		int size = N * N;
		for (int i = 0; i < size; i++) {
			for (int j = 1; j < size; j++) {
				for (int k = 2; k < size; k++) {
					if (i == j || j == k || k == i)
						continue;
					if (i / N == 0 || j / N == 0 || k / N == 0)
						continue;
					if (i % N == 0 || j % N == 0 || k % N == 0)
						continue;
					if (i / N == N - 1 || j / N == N - 1 || k / N == N - 1)
						continue;
					if (i % N == N - 1 || j % N == N - 1 || k % N == N - 1)
						continue;
					isPossible(i, j, k);
				}
			}
		}
		System.out.println(min);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void isPossible(int a, int b, int c) {
		int[][] visited = new int[N][N];
		int[] tmp = { a, b, c };

		int sum = 0;

		for (int i = 0; i < 3; i++) {
			sum += map[tmp[i] / N][tmp[i] % N];
			visited[tmp[i] / N][tmp[i] % N] = 1;
			for (int j = 0; j < 4; j++) {
				int nr = tmp[i] / N + dr[j];
				int nc = tmp[i] % N + dc[j];
				if (visited[nr][nc] == 1) {
					return;
				}
				visited[nr][nc] = visited[nr][nc] + 1;
				sum += map[nr][nc];
			}
		}
		min = Math.min(min, sum);
	}
}
//https://www.acmicpc.net/problem/14620