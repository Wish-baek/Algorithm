import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold18405 {
	static int[][] map;
	static int N;

	static class Virus {
		int r;
		int c;
		int num;

		public Virus(int r, int c, int num) {
			this.r = r;
			this.c = c;
			this.num = num;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken()) - 1;
		int Y = Integer.parseInt(st.nextToken()) - 1;
		loop: for (int i = 0; i < S; i++) {
			for (int j = 0; j < K; j++) {
				spread(j + 1);
				if (map[X][Y] != 0)
					break loop;
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		System.out.println(map[X][Y]);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void spread(int v) {
		Queue<Virus> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == v) {
					int num = map[i][j];
					q.add(new Virus(i, j, num));
				}
			}
		}

		while (!q.isEmpty()) {
			Virus virus = q.poll();
			int r = virus.r;
			int c = virus.c;
			int n = virus.num;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0)
					continue;
				map[nr][nc] = n;

			}
		}
	}

}
//https://www.acmicpc.net/problem/18405