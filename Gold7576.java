import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold7576 {
	static int[][] map;
	static int[][] visited;
	static int cnt, M, N, x, nx, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken()); // 열
		N = Integer.parseInt(st.nextToken()); // 행
		map = new int[N][M];
		visited = new int[N][M];
		int sr = -1;
		int sc = 1;
		x = 0;
		nx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1) {
					sr = i;
					sc = j;
					nx++;
				} else if (map[i][j] == -1) {
					visited[i][j] = -1;
					x++;
				}
			}
		}

		if (x + nx == N * M) {
			System.out.println(0);
			System.exit(0);
		}

		cnt = 0;
		bfs();
		// System.out.println(cnt);
		if (cnt == N * M - x - nx) {
			System.out.println(result);
		} else
			System.out.println(-1);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {

				if (map[i][j] == 1) {
					q.add(new int[] { i, j });

				}
			}
		}
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			if (cnt == N * M - x - nx) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || map[nr][nc] == -1 || map[nr][nc] == 1)
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = visited[r][c] + 1;

				map[nr][nc] = 1;
				cnt++;
			}
		}

		result = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result = Math.max(result, visited[i][j]);
			}
		}
	}
}
//https://www.acmicpc.net/problem/7576