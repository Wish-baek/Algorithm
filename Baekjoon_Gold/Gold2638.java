import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2638 {
	static cheese[][] map;
	static int N, M;

	static class cheese {
		int isCheese;
		int contactAir;
		boolean visited;

		public cheese(int isCheese, int contactAir, boolean visited) {
			this.isCheese = isCheese;
			this.contactAir = contactAir;
			this.visited = visited;
		}

		public void setIsCheese(int isCheese) {
			this.isCheese = isCheese;
		}

		public void setContactAir(int contactAir) {
			this.contactAir = contactAir;
		}

		public void setVisited(boolean visited) {
			this.visited = visited;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new cheese[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				map[i][j] = new cheese(n, 0, false);
			}
		}
		int time = 0;
		while (true) {

			bfs();
			melt();
			time++;
			if (checkAllMelt())
				break;

		}
		System.out.println(time);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		map[0][0].setVisited(true);

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc].isCheese == 0 && map[nr][nc].visited)
					continue;

				else if (map[nr][nc].isCheese == 1) {
					map[nr][nc].setContactAir(map[nr][nc].contactAir + 1);

				} else {
					map[nr][nc].setVisited(true);
					q.add(new int[] { nr, nc });
				}

			}
		}
	}

	static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j].setVisited(false);
				if (map[i][j].isCheese == 1 && map[i][j].contactAir >= 2) {
					map[i][j].setIsCheese(0);
				}
				map[i][j].setContactAir(0);
			}
		}
	}

	static boolean checkAllMelt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j].isCheese == 1) {
					return false;
				}
			}
		}
		return true;
	}
}
//https://www.acmicpc.net/problem/2638