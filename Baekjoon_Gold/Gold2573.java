import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2573 {

	static int[][] map;
	static boolean[][] visited;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		int count = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0)
					count++;
			}
		}

		if (howManyChuncks() == 2 || count == 1) {
			System.out.println(0);
			System.exit(0);
		}

		int year = 0;

		while (true) {
			
			melt();year++;
			int ck = howManyChuncks();
			if (ck >= 2)
				break;
			if (ck == -1) {
				System.out.println(0);
				System.exit(0);
			}
			

		}

		System.out.println(year);

		

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void melt() {

		int[][] tmpMap = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmpMap[i][j] = map[i][j];
			}
		}

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmpMap[i][j] != 0)
					q.add(new int[] { i, j });
			}
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (tmpMap[nr][nc] == 0)
					cnt++;

			}
			if (map[r][c] - cnt < 0)
				map[r][c] = 0;
			else
				map[r][c] -= cnt;
		}

	}

	static int howManyChuncks() {
		visited = new boolean[N][M];
		int cnt = 0;
		int sea = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				
				if (!visited[i][j] && map[i][j] != 0) {
					bfs(i, j);
//					System.out.println("r: "+i + " c: " + j);
					cnt++;
				}
				if (map[i][j] == 0)
					sea++;
			}
		}
		if (sea == N * M)
			return -1;
		else
			return cnt;
	}

	static void bfs(int sr, int sc) {
		
		Queue<int[]> q = new LinkedList<>();
		visited[sr][sc] = true;

		q.add(new int[] { sr, sc });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == 0 || visited[nr][nc])
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;

			}
		}
	}

}
//https://www.acmicpc.net/problem/2573