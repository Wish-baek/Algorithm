import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16469 {
	static int[][] map;
	static int[][][] visited;
	static int R, C;
	static person[] per;

	static class person {
		int r;
		int c;

		public person(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		visited = new int[R][C][3];

		per = new person[3];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			per[i] = new person(r, c);
		}

		for (int i = 0; i < 3; i++) {
			bfs(per[i].r, per[i].c, i);
		}

		int min = Integer.MAX_VALUE;
		int cnt = 1;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visited[i][j][0] == 0 || visited[i][j][1] == 0 || visited[i][j][2] == 0)
					continue;

				int n = Math.max(visited[i][j][0], Math.max(visited[i][j][1], visited[i][j][2]));
				if (n < min) {
					min = n;
					cnt = 1;
				} else if (n == min)
					cnt++;
			}

		}
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(min - 1);
			System.out.println(cnt);
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc, int idx) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { sr, sc });
		visited[sr][sc][idx] = 1;

		while (!q.isEmpty()) {
			int[] per = q.poll();
			int r = per[0];
			int c = per[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (visited[nr][nc][idx] != 0 || map[nr][nc] == 1)
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc][idx] = visited[r][c][idx] + 1;
			}
		}
	}
}
//https://www.acmicpc.net/problem/16469