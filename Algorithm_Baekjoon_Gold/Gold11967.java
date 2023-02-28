import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold11967 {
	static List<info>[][] map;
	static boolean[][] isBright, visited, canMove;
	static int N, M, cnt;

	static class info {
		int r;
		int c;

		public info(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N + 1][N + 1];
		isBright = new boolean[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];
		canMove = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			map[x][y].add(new info(a, b));
		}
		cnt = 1;

		bfs();
		System.out.println(cnt);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<info> q = new LinkedList<>();
		q.add(new info(1, 1));
		visited[1][1] = true;
		isBright[1][1] = true;

		while (!q.isEmpty()) {
			info now = q.poll();
			int r = now.r;
			int c = now.c;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 1 || nr > N || nc < 1 || nc > N)
					continue;

				canMove[nr][nc] = true;
			}

			for (int i = 0; i < map[r][c].size(); i++) {
				info p = map[r][c].get(i);

				if (!isBright[p.r][p.c]) {
					isBright[p.r][p.c] = true;
					cnt++;
				}

				if (canMove[p.r][p.c] && !visited[p.r][p.c]) {
					visited[p.r][p.c] = true;
					q.add(new info(p.r, p.c));
				}
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 1 || nr > N || nc < 1 || nc > N)
					continue;

				if (isBright[nr][nc] && !visited[nr][nc] && canMove[nr][nc]) {
					visited[nr][nc] = true;
					q.add(new info(nr, nc));
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/11967