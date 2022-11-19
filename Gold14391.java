import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold14391 {
	static boolean[][] visited;
	static int[][] memo;
	static int[][] map;
	static int N, M, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		memo = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		result = Integer.MIN_VALUE;
		backtracking(0, 0);
		System.out.println(result);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void backtracking(int r, int c) {

		if (r == N - 1 && c >= M) {
			int n = cal();
			result = Math.max(n, result);
			return;
		}

		if (c >= M) {
			r++;
			c = 0;
		}
		memo[r][c] = 1;
		backtracking(r, c + 1);
		memo[r][c] = -1;
		backtracking(r, c + 1);
	}

	static int cal() {
		int total = 0;
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j]) {
					if (memo[i][j] == -1) {
						int sum = 0;
						int r = i;
						int c = j;

						while (true) {
							if (r < 0 || r >= N || c < 0 || c >= M)
								break;
							if (memo[r][c] == 1) {
								break;
							}
							sum = sum * 10 + map[r][c];
							visited[r][c] = true;
							r++;
						}
						total += sum;
					}

					else if (memo[i][j] == 1) {
						int sum = 0;
						int r = i;
						int c = j;
						while (true) {

							if (r < 0 || r >= N || c < 0 || c >= M)
								break;
							if (memo[r][c] == -1) {
								break;
							}
							sum = sum * 10 + map[r][c];
							visited[r][c] = true;
							c++;
						}
						total += sum;
					}
				}
			}
		}
		return total;
	}
}
//https://www.acmicpc.net/problem/14391