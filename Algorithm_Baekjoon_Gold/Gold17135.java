import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Gold17135 {
	static int[][] map, distance;
	static boolean[] visited;
	static List<Point> enemy, goongsu;
	static int N, M, D, max;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}

		public void setR(int r) {
			this.r = r;
		}

		public void setC(int c) {
			this.c = c;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N + 1][M];
		distance = new int[N + 1][M];
		visited = new boolean[M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// --------------------------------------------------
//
//		enemy = new ArrayList<>(); // 적 리스트
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				if (map[i][j] == 1)
//					enemy.add(new Point(i, j));
//			}
//		}
//		goongsu = new ArrayList<>(); // 궁수 리스트
//
//		goongsu.add(new Point(N, 0));
//		goongsu.add(new Point(N, 2));
//		goongsu.add(new Point(N, 4));
//		max = -1;
//		int n = play();
//		max = Math.max(max, n);

		// --------------------------------------------------

		dfs(0, 0);
		System.out.println(max);

	}

	static int play() {
		int cnt = 0;
		while (true) {
			int[] kill = new int[enemy.size()];
//			System.out.println(enemy.get(0).r + " " + enemy.get(0).c);
//			System.out.println(enemy.size() + " "+goongsu.size());
			for (int i = 0; i < goongsu.size(); i++) {
				int min = Integer.MAX_VALUE;
				int min_c = Integer.MAX_VALUE;
				int min_idx = -1;

				for (int j = 0; j < enemy.size(); j++) {
					int dist = Math.abs(goongsu.get(i).r - enemy.get(j).r)
							+ Math.abs(goongsu.get(i).c - enemy.get(j).c);
					if (dist <= D) {
						if (dist < min) {
							min = dist;
							min_c = enemy.get(j).c;
							min_idx = j;
						} else if (dist == min && enemy.get(j).c < min_c) {
							min = dist;
							min_c = enemy.get(j).c;
							min_idx = j;
						}
					}
				}
				if (min_idx != -1) {
					kill[min_idx]++;
				}

			}

			int tmp = 0;

			for (int i = 0; i < kill.length; i++) {
				if (kill[i] > 0) {
					enemy.remove(i - tmp);
					cnt++;
					tmp++;
				}
			}

			for (int i = 0; i < enemy.size(); i++) {
				int r = enemy.get(i).r;
				int c = enemy.get(i).c;
				enemy.set(i, new Point(r + 1, c));
			}

			boolean ck = false;
			if (enemy.size() == 0)
				break;

			for (int i = 0; i < enemy.size(); i++) {
				if (enemy.get(i).r == N) {
					enemy.remove(i);
					i--;
				}
			}
			if (ck)
				break;
		}
		return cnt;
	}

	static void dfs(int at, int cnt) {
		if (cnt == 3) {
			int sum = 0;

			enemy = new ArrayList<>(); // 적 리스트
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1)
						enemy.add(new Point(i, j));
				}
			}

			goongsu = new ArrayList<>(); // 궁수 리스트

			for (int i = 0; i < M; i++) {
				if (visited[i]) {
					goongsu.add(new Point(N, i));
				}
			}

			int n = play();
			max = Math.max(max, n);
		}

		for (int i = at; i < M; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/17135