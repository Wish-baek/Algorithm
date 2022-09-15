import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold14466 {
	static List<Point>[][] bridge;
	static int[][] map;
	static List<Point> cowList;
	static int N, cnt;

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
		int K = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		bridge = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bridge[i][j] = new ArrayList<>();
			}
		}
		cowList = new ArrayList<>();

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int r2 = Integer.parseInt(st.nextToken()) - 1;
			int c2 = Integer.parseInt(st.nextToken()) - 1;
			bridge[r][c].add(new Point(r2, c2));
			bridge[r2][c2].add(new Point(r, c));
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			cowList.add(new Point(r, c));
		}

		for (int i = 0; i < K - 1; i++) {
			for (int j = i + 1; j < K; j++) {

				int sr = cowList.get(i).r;
				int sc = cowList.get(i).c;
				int fr = cowList.get(j).r;
				int fc = cowList.get(j).c;
				bfs(sr, sc, fr, fc);
			}
		}
		System.out.println(cnt);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc, int fr, int fc) {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			if (r == fr && c == fc)
				break;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc])
					continue;
				boolean ck = true;
				for (int k = 0; k < bridge[r][c].size(); k++) {
					if (bridge[r][c].get(k).r == nr && bridge[r][c].get(k).c == nc) {

						ck = false;
						break;
					}
				}
				if (ck == false)
					continue;
//				System.out.println(r + " " + c + " " + nr + " " + nc);
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(visited[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();

		}
		if (visited[fr][fc] == false)
			cnt++;

	}

}
//https://www.acmicpc.net/problem/14466