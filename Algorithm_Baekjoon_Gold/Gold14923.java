import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold14923 {
	static int[][][] visited;
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int Hx = Integer.parseInt(st.nextToken()) - 1;
		int Hy = Integer.parseInt(st.nextToken()) - 1;

		st = new StringTokenizer(br.readLine(), " ");
		int Ex = Integer.parseInt(st.nextToken()) - 1;
		int Ey = Integer.parseInt(st.nextToken()) - 1;

		map = new int[N][M];
		visited = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		bfs(Hx, Hy, Ex, Ey);

		int a = visited[Ex][Ey][0] - 1;
		int b = visited[Ex][Ey][1] - 1;

		if (a == -1 && b == -1)
			System.out.println(-1);
		else if (a == -1 && b != -1)
			System.out.println(b);
		else if (a != -1 && b == -1)
			System.out.println(a);
		else
			System.out.println(Math.min(a, b));

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc, int fr, int fc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc, 0 });
		visited[sr][sc][0] = 1;
		visited[sr][sc][1] = 1;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int cnt = tmp[2];

			if (cnt == 0) {
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (visited[nr][nc][0] != 0 || map[nr][nc] == 1)
						continue;
					visited[nr][nc][0] = visited[r][c][0] + 1;
					q.add(new int[] { nr, nc, 0 });
				}
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (visited[nr][nc][1] != 0)
						continue;
					visited[nr][nc][1] = visited[r][c][0] + 1;
					q.add(new int[] { nr, nc, 1 });
				}
			}

			else if (cnt == 1) {

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (visited[nr][nc][1] != 0 || map[nr][nc] == 1)
						continue;
					visited[nr][nc][1] = visited[r][c][1] + 1;
					q.add(new int[] { nr, nc, 1 });
				}
			}

		}
	}
}
//https://www.acmicpc.net/problem/14923