import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold6087 {
	static int R, C, result;
	static char[][] map;
	static int[][] visited;
	static node[] mList;

	static class node {
		int r;
		int c;
		int d;
		int cnt;

		public node(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new int[R][C];
		int tmp = 0;

		int sr = -1;
		int sc = -1;
		int fr = -1;
		int fc = -1;
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'C') {
					if (tmp++ == 0) {
						sr = i;
						sc = j;
					} else {
						fr = i;
						fc = j;
					}
				}
			}
		}

		result = Integer.MAX_VALUE;

		bfs(sr, sc, fr, fc);
		System.out.println(result);
	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	static void bfs(int sr, int sc, int fr, int fc) {
		visited = new int[R][C];
		Queue<node> q = new LinkedList<>();
		q.add(new node(sr, sc, -1, 0));
		visited[sr][sc] = 1;
		while (!q.isEmpty()) {
			node now = q.poll();
			int r = now.r;
			int c = now.c;
			int d = now.d;
			int cnt = now.cnt;

			if (r == fr && c == fc) {
				result = Math.min(result, visited[r][c]);
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (map[nr][nc] == '*')
					continue;

				int m = cnt;
				if (d != -1 && d != i) {
					m++;
				}

				if (visited[nr][nc] == 0) {
					visited[nr][nc] = m;
					q.add(new node(nr, nc, i, m));
				} else if (visited[nr][nc] >= m) {
					visited[nr][nc] = m;
					q.add(new node(nr, nc, i, m));
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/6087