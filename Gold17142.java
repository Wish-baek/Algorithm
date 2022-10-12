import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold17142 {
	static List<Point> virusList;
	static int[][] map;
	static boolean[] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, M, result;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		virusList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 2)
					virusList.add(new Point(i, j));
			}
		}
		visited = new boolean[virusList.size()];
		result = Integer.MAX_VALUE;
		comb(0, 0);
		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static void comb(int depth, int at) {

		if (depth == M) {
//			if (map[0][0]==3 && map[1][5]==3 && map[4][3]==3)
			bfs();
			return;
		}

		for (int i = at; i < virusList.size(); i++) {
			if (!visited[i]) {
				int r = virusList.get(i).r;
				int c = virusList.get(i).c;
				visited[i] = true;
				int tmp = map[r][c];
				map[r][c] = 3;
				comb(depth + 1, i + 1);
				map[r][c] = tmp;
				visited[i] = false;
			}
		}
	}

	private static void bfs() {
		int[][] visited2 = new int[N][N];
		Queue<Point> q = new LinkedList<>();
		int empty = 0;
		int wallCnt = 0;
		int virusCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 3) {
					q.add(new Point(i, j));
					visited2[i][j] = 1;
					virusCnt++;
				} else if (map[i][j] == 2)
					virusCnt++;
				else if (map[i][j] == 1)
					wallCnt++;
			}
		}

		if (wallCnt + virusCnt == N * N) {
			System.out.println(0);
			System.exit(0);
		}

		int time = 0;
		while (!q.isEmpty()) {

			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point now = q.poll();
				int r = now.r;
				int c = now.c;
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;

					if (visited2[nr][nc] == 0 && map[nr][nc] != 1) {
						if (map[nr][nc] == 0)
							virusCnt++;
						visited2[nr][nc] = visited2[r][c] + 1;
						q.add(new Point(nr, nc));
//						temp[nr][nc] = 3;
					}
				}

			}
			time++;
			if (wallCnt + virusCnt == N * N)
				result = Math.min(result, time);
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(visited2[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

	}
}