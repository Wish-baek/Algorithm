import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2636 {
	static int[][] map;
	static boolean[][] visited;
	static int N, M, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int min = Integer.MAX_VALUE;
		int time = 0;
		while (true) {
			cnt = 0;
			int remain = cal();
			bfs();

			if (remain != 0)
				min = Math.min(min, remain);

			if (remain == 0)
				break;
			time++;
		}

		System.out.println(time);
		System.out.println(min);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visited[nr][nc])
					continue;
				if (map[nr][nc] == 1) {
					map[nr][nc] = 0;
					visited[nr][nc] = true;
					continue;
				}

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });

			}
		}

//		System.out.println(cnt);
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

	}

	static int cal() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					cnt++;
			}
		}
		return cnt;
	}

}
//https://www.acmicpc.net/problem/2636