import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold17836 {

	static int[][] map;
	static int[][] visited;
	static int N, M, T;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		int gr = -1;
		int gc = -1;

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2) {
					gr = i;
					gc = j;
				}
			}
		}

		int result1 = -1;
		int result2 = -1;

		int a = bfs(0, 0, gr, gc, false);
		int b = bfs(gr, gc, N - 1, M - 1, true);

		if (a != -1 && b != -1)
			result1 = a + b - 1;

		result2 = bfs(0, 0, N - 1, M - 1, false);

		if (result1 == -1 && result2 == -1) {
			System.out.println("Fail");
		} else if (result1 == -1 && result2 != -1) {
			if (result2 - 1 <= T)
				System.out.println(result2 - 1);
			else
				System.out.println("Fail");
		} else if (result1 != -1 && result2 == -1) {
			if (result1 - 1 <= T)
				System.out.println(result1 - 1);
			else
				System.out.println("Fail");
		} else if (Math.min(result1, result2) - 1 <= T) {
			System.out.println(Math.min(result1, result2) - 1);

		} else
			System.out.println("Fail");
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs(int sr, int sc, int fr, int fc, boolean gram) {
		visited = new int[N][M];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = 1;

		while (!q.isEmpty()) {

			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			if (r == fr && c == fc) {
				return visited[fr][fc];
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0)
					continue;

				if (gram == true) {
					visited[nr][nc] = visited[r][c] + 1;
					q.add(new int[] { nr, nc });

				} else if (gram == false) {
					if (map[nr][nc] == 0 || map[nr][nc] == 2) {
						visited[nr][nc] = visited[r][c] + 1;
						q.add(new int[] { nr, nc });
					}
				}
			}

		}
		return -1;
	}

}
//https://www.acmicpc.net/problem/17836