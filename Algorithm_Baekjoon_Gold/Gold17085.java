import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold17085 {
	static boolean[][] visited, tmp;
	static char[][] map;
	static int N, M, size, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		result = -1;

		dfs(0, 1);

		System.out.println(result);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int depth, int total) {

		if (depth == 2) {
			result = Math.max(result, total);
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] != '#')
					continue;

				boolean ck = true;

				for (int k = 1; k <= 8; k++) {
					if (check(i, j, k)) {
						map[i][j] = '*';
						draw(i, j, k, '*');
						dfs(depth + 1, total * (k * 4 + 1));
						draw(i, j, k, '#');
						map[i][j] = '#';
					} else {
						ck = false;
						break;
					}
				}
				if (!ck) {
					map[i][j] = '*';
					dfs(depth + 1, total);
					map[i][j] = '#';
				}
			}
		}
	}

	static boolean check(int r, int c, int k) {
		for (int repeat = 1; repeat <= k; repeat++) {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i] * repeat;
				int nc = c + dc[i] * repeat;
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] != '#')
					return false;
			}
		}
		return true;
	}

	static void draw(int r, int c, int k, char stat) {
		for (int repeat = 1; repeat <= k; repeat++) {
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i] * repeat;
				int nc = c + dc[i] * repeat;
				map[nr][nc] = stat;
			}
		}
	}
}
//https://www.acmicpc.net/problem/17085