import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold21608 {
	static int[][] satisfaction;
	static boolean[][] visited;
	static int[][] map;
	static List<Integer>[] prefer;
	static int[] order;
	static int N, result;

	static class Point implements Comparable<Point> {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Point o) {
			if (this.r == o.r) {
				return this.c - o.c;
			} else
				return this.r - o.r;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		prefer = new ArrayList[N * N + 1];
		order = new int[N * N];

		for (int i = 0; i < N * N + 1; i++) {
			prefer[i] = new ArrayList<>();
		}

		for (int i = 1; i < N * N + 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			order[i - 1] = num;

			for (int j = 0; j < 4; j++) {
				prefer[num].add(Integer.parseInt(st.nextToken()));
			}
		}

		for (int k = 0; k < N * N; k++) {
			condition1(order[k]);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (prefer[map[i][j]].contains(map[nr][nc]))
						cnt++;
				}
				result += Math.pow(10, cnt - 1);
			}
		}
		System.out.println(result);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void condition1(int num) {
		visited = new boolean[N][N];
		int max = -1;
		int dupl = 0;
		int max_r = -1;
		int max_c = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					continue;
				int cnt = 0;
				int r = i;
				int c = j;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (map[nr][nc] == 0)
						continue;
					if (prefer[num].contains(map[nr][nc])) {
						cnt++;
					}
				}
				if (cnt == max) {
					dupl++;
					visited[i][j] = true;
				} else if (cnt > max) {
					max = cnt;
					max_r = i;
					max_c = j;
					dupl = 1;
					visited = new boolean[N][N];
					visited[i][j] = true;
				}
			}
		}
		if (max == 0 || dupl > 0) {
			condition2(num);
		} else {
			map[max_r][max_c] = num;
		}
	}

	static void condition2(int num) {
		PriorityQueue<Point> q = new PriorityQueue<>();

		int max = -1;
		int max_r = -1;
		int max_c = -1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j])
					continue;
				int cnt = 0;
				int r = i;
				int c = j;

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					if (map[nr][nc] == 0)
						cnt++;
				}
				if (cnt == max)
					q.add(new Point(i, j));
				if (cnt > max) {
					max = cnt;
					max_r = i;
					max_c = j;
					q.clear();
					q.add(new Point(i, j));
				}
			}
		}
		if (q.size() > 1) {
			Point p = q.poll();
			map[p.r][p.c] = num;
		} else {
			map[max_r][max_c] = num;
		}
	}
}
//https://www.acmicpc.net/problem/21608