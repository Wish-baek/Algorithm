import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold15683 {
	static List<cctv> list;
	static int[][] visited;
	static int N, M, min;

	static class cctv {
		int r;
		int c;
		int d;

		public cctv(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] map = new int[N][M];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (0 < map[i][j] && map[i][j] < 6)
					list.add(new cctv(i, j, map[i][j]));
			}
		}
		min = Integer.MAX_VALUE;
		visited = new int[N][M];
		dfs(map, 0);
		System.out.println(min);

	}

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };
	static int[][][] cDir = { { { 0 } }, { { 0 }, { 1 }, { 2 }, { 3 } }, // cDir[1][0]
			{ { 0, 2 }, { 1, 3 } }, // cDir[2].length = 2;
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } },
			{ { 0, 1, 2, 3 } } };

	static void dfs(int[][] map, int idx) {

		if (idx == list.size()) {
			int n = calSpot(map);
//			System.out.println(n);
//			for (int a = 0; a < N; a++) {
//				for (int b = 0; b < M; b++) {
//					System.out.print(map[a][b] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			min = Math.min(min, n);
			return;
		}

		int r = list.get(idx).r;
		int c = list.get(idx).c;
		int d = list.get(idx).d;

		for (int i = 0; i < cDir[d].length; i++) {
			for (int j = 0; j < cDir[d][i].length; j++) {
				int nr = r;
				int nc = c;
				int tmp = cDir[d][i][j];
				while (true) {
					nr = nr + dr[tmp];
					nc = nc + dc[tmp];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						break;
					if (map[nr][nc] == 6)
						break;
					if (map[nr][nc] == 0)
						map[nr][nc] = 8;
					visited[nr][nc] = visited[nr][nc] + 1;

				}

			}
			dfs(map, idx + 1);

			for (int j = 0; j < cDir[d][i].length; j++) {
				int nr = r;
				int nc = c;
				int tmp = cDir[d][i][j];
				while (true) {
					nr = nr + dr[tmp];
					nc = nc + dc[tmp];

					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						break;
					if (map[nr][nc] == 6)
						break;
					visited[nr][nc]--;
					if (visited[nr][nc] == 0 && map[nr][nc] == 8)
						map[nr][nc] = 0;

				}
			}
		}

	}

	static int calSpot(int[][] arr) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0)
					sum++;
			}
		}
		return sum;
	}

}
//https://www.acmicpc.net/problem/15683