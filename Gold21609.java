import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold21609 {
	static int[][] map;
	static boolean[][] visitedNormal, visitedRainbow;
	static int N, cnt, rainbow;

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point implements Comparable<Point> {
		int r;
		int c;
		int rainbow;
		int size;

		public Point(int r, int c, int rainbow, int size) {
			this.r = r;
			this.c = c;
			this.rainbow = rainbow;
			this.size = size;
		}

		@Override
		public int compareTo(Point o) {
			if (this.size == o.size) {
				if (this.rainbow == o.rainbow) {
					if (this.r == o.r) {
						return o.c - this.c;
					}
					return o.r - this.r;
				}
				return o.rainbow - this.rainbow;
			}
			return o.size - this.size;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];

		visitedNormal = new boolean[N][N];
		visitedRainbow = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		PriorityQueue<Point> q = new PriorityQueue<>();
		int result = 0;
		int time = 1;
		while (true) {
			visitedNormal = new boolean[N][N];
			visitedRainbow = new boolean[N][N];
			q.clear();

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] > 0 && !visitedNormal[i][j]) {
						visitedRainbow = new boolean[N][N];
						cnt = 1;
						rainbow = 0;
						bfs(i, j, map[i][j], false);
						if (cnt >= 2) {
							q.add(new Point(i, j, rainbow, cnt));
						}
					}
				}
			}
			if (q.isEmpty())
				break;
			Point p = q.poll();
			int r = p.r;
			int c = p.c;

			visitedNormal = new boolean[N][N];
			visitedRainbow = new boolean[N][N];

			int num = map[r][c];
			bfs(r, c, num, true);
			result += p.size * p.size;

			gravity();
			rotate();
			gravity();
		}
		System.out.println(result);

	}

	static void rotate() {
		int[][] tmp = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[j][N - 1 - i];
			}
		}
		map = tmp;
	}

	static void gravity() {
		for (int i = N - 2; i >= 0; i--) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == -1)
					continue;
				int r = i;
				int c = j;

				while (true) {
					if (r + 1 >= N || map[r + 1][c] != -2)
						break;
					r++;
				}
				int tmp = map[i][j];
				map[i][j] = -2;
				map[r][c] = tmp;
			}
		}
	}

	static void bfs(int sr, int sc, int num, boolean delete) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		if (delete)
			map[sr][sc] = -2;
		visitedNormal[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int r = p[0];
			int c = p[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visitedNormal[nr][nc] || visitedRainbow[nr][nc])
					continue;
				if (map[nr][nc] != 0 && map[nr][nc] != num)
					continue;

				if (map[nr][nc] == 0) {
					visitedRainbow[nr][nc] = true;
					rainbow++;
					cnt++;
				} else {
					visitedNormal[nr][nc] = true;
					cnt++;
				}

				if (delete)
					map[nr][nc] = -2;

				q.add(new int[] { nr, nc });
			}
		}
	}
}
//https://www.acmicpc.net/problem/21609