import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Gold1726 {
	static boolean[][][] visited;
	static int[][] map;
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int M, N, result;

	static class robot {
		int r;
		int c;
		int d;

		int total;

		public robot(int r, int c, int d, int total) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.total = total;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new boolean[M][N][4];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken()) - 1;
		int sc = Integer.parseInt(st.nextToken()) - 1;
		int sd = Integer.parseInt(st.nextToken()) - 1;

		if (sd == 0)
			sd = 1;
		else if (sd == 1)
			sd = 3;
		else if (sd == 2)
			sd = 2;
		else if (sd == 3)
			sd = 0;

		st = new StringTokenizer(br.readLine(), " ");
		int fr = Integer.parseInt(st.nextToken()) - 1;
		int fc = Integer.parseInt(st.nextToken()) - 1;
		int fd = Integer.parseInt(st.nextToken()) - 1;

		if (fd == 0)
			fd = 1;
		else if (fd == 1)
			fd = 3;
		else if (fd == 2)
			fd = 2;
		else if (fd == 3)
			fd = 0;

		result = Integer.MAX_VALUE;
		bfs(sr, sc, sd, fr, fc, fd);

		System.out.println(result);
	}

	static void bfs(int sr, int sc, int sd, int fr, int fc, int fd) {
		Deque<robot> q = new LinkedList<>();
		q.add(new robot(sr, sc, sd, 0));
		visited[sr][sc][sd] = true;

		while (!q.isEmpty()) {
			robot rb = q.poll();
			int r = rb.r;
			int c = rb.c;
			int d = rb.d;
			int total = rb.total;

			if (r == fr && c == fc && d == fd) {
				result = Math.min(result, total);
				continue;
			}

			for (int k = 1; k <= 3; k++) {
				int nr = r + dr[d] * k;
				int nc = c + dc[d] * k;

				if (nr < 0 || nr >= M || nc < 0 || nc >= N)
					continue;
				if (map[nr][nc] == 1)
					break;
				if (visited[nr][nc][d])
					continue;

				else {
					q.add(new robot(nr, nc, d, total + 1));
					visited[nr][nc][d] = true;
				}
			}
			int left = d - 1 < 0 ? d - 1 + 4 : d - 1;
			if (!visited[r][c][left]) {
				visited[r][c][left] = true;
				q.add(new robot(r, c, left, total + 1));
			}

			int right = (d + 1) % 4;
			if (!visited[r][c][right]) {
				visited[r][c][right] = true;
				q.add(new robot(r, c, right, total + 1));
			}
		}
	}
}
//https://www.acmicpc.net/problem/1726