import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold17779 {
	static int[][] map;
	static int[][] visited;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { 1, -1, -1, 1 };

	static int N, max, min, total, result;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		visited = new int[N][N];
		Point[] info = new Point[4];

		total = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		result = Integer.MAX_VALUE;
		for (int i = 1; i < N - 1; i++) {
			for (int j = 1; j < N - 1; j++) {
				drawing(info, true, i, j, 0, i, j);
			}
		}

		System.out.println(result);

	}

	static void drawing(Point[] info, boolean start, int startR, int startC, int dir, int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= N)
			return;

		if (!start && r == startR && c == startC) {
			max = -1;
			min = Integer.MAX_VALUE;

			int n1 = cal(info, 0);
			int n2 = cal(info, 1);
			int n3 = cal(info, 2);
			int n4 = cal(info, 3);
			int n5 = total - n1 - n2 - n3 - n4;

			max = Math.max(n1, Math.max(n2, Math.max(n3, Math.max(n4, n5))));
			min = Math.min(n1, Math.min(n2, Math.min(n3, Math.min(n4, n5))));

			result = Math.min(result, max - min);
			return;
		}
		visited[r][c] = 1;
		if (start) {
			info[0] = new Point(r, c);
			drawing(info, false, startR, startC, 0, r + dr[0], c + dc[0]);
		} else if (dir == 0 && !start) {
			info[1] = new Point(r, c);
			drawing(info, false, startR, startC, 1, r + dr[1], c + dc[1]);
			drawing(info, false, startR, startC, 0, r + dr[0], c + dc[0]);

		} else if (dir == 1) {
			info[2] = new Point(r, c);
			drawing(info, false, startR, startC, 2, r + dr[2], c + dc[2]);
			drawing(info, false, startR, startC, 1, r + dr[1], c + dc[1]);

		} else if (dir == 2) {
			info[3] = new Point(r, c);
			drawing(info, false, startR, startC, 3, r + dr[3], c + dc[3]);
			drawing(info, false, startR, startC, 2, r + dr[2], c + dc[2]);

		} else if (dir == 3) {
			drawing(info, false, startR, startC, 3, r + dr[3], c + dc[3]);
		}

		visited[r][c] = 0;

	}

	private static int cal(Point[] info, int where) {

		if (where == 0) {
			int tmp = 0;
			int sum = 0;
			for (int i = 0; i < info[3].r; i++) {
				if (i >= info[0].r)
					tmp++;
				for (int j = 0; j <= info[0].c; j++) {
					if (j <= info[0].c - tmp) {
						sum += map[i][j];
					}
				}
			}
			return sum;
		} else if (where == 1) {
			int tmp = info[0].c + 1;
			int sum = 0;
			for (int i = 0; i <= info[1].r; i++) {
				if (i > info[0].r)
					tmp++;
				for (int j = tmp; j < N; j++) {
					sum += map[i][j];
				}
			}
			return sum;
		} else if (where == 2) {
			int tmp = info[3].c;
			int sum = 0;
			int j = 0;
			for (int i = info[3].r; i < N; i++) {
				for (j = 0; j < tmp; j++) {
					sum += map[i][j];
				}
				if (j < info[2].c)
					tmp++;
			}
			return sum;
		} else if (where == 3) {
			int tmp = info[1].c;
			int sum = 0;
			int j = tmp;
			for (int i = info[1].r + 1; i < N; i++) {
				for (j = tmp; j < N; j++) {
					sum += map[i][j];
				}
				if (i <= info[2].r)
					tmp--;
			}
			return sum;
		}
		return 0;
	}
}
//https://www.acmicpc.net/problem/17779