import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2194 {
	static boolean[][] map;
	static int N, M, A, B;
	static point start, end;

	static class point {
		int r;
		int c;
		int cnt;

		public point(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new boolean[N][M];

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			map[r][c] = true;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		start = new point(sr, sc, 0);

		st = new StringTokenizer(br.readLine(), " ");
		int fr = Integer.parseInt(st.nextToken()) - 1;
		int fc = Integer.parseInt(st.nextToken()) - 1;
		end = new point(fr, fc, 0);

		System.out.println(bfs());

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs() {
		boolean[][] visited = new boolean[N][M];
		Queue<point> q = new LinkedList<>();
		q.add(new point(start.r, start.c, 0));
		visited[start.r][start.c] = true;

		while (!q.isEmpty()) {
			point p = q.poll();
			int r = p.r;
			int c = p.c;
			int cnt = p.cnt;
			if (r == end.r && c == end.c) {
				return cnt;
			}

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visited[nr][nc])
					continue;

				if (nr + A - 1 < 0 || nr + A - 1 >= N || nc + B - 1 < 0 || nc + B - 1 >= M)
					continue;

				boolean isPossible = true;

				for (int i = nr; i < nr + A; i++) {
					for (int j = nc; j < nc + B; j++) {
						if (map[i][j]) {
							isPossible = false;
							break;
						}
					}
					if (!isPossible)
						break;
				}

				if (isPossible) {
					visited[nr][nc] = true;
					q.add(new point(nr, nc, cnt + 1));
				}

			}
		}
		return -1;
	}
}
//https://www.acmicpc.net/problem/2194