import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold14442 {
	static int[][] map;
	static int[][][] visited;
	static int N, M, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M][K + 1];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		bfs();

		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if (visited[N - 1][M - 1][i] != 0)
				min = Math.min(min, visited[N - 1][M - 1][i]);
		}
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0 });
		for (int i = 0; i <= K; i++) {
			visited[0][0][i] = 1;
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int k = tmp[2];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visited[nr][nc][k] != 0 || map[nr][nc] == 1)
					continue;
				visited[nr][nc][k] = visited[r][c][k] + 1;
				q.add(new int[] { nr, nc, k });
			}

			if (k < K) {

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= N || nc < 0 || nc >= M)
						continue;
					if (visited[nr][nc][k + 1] != 0)
						continue;
					visited[nr][nc][k + 1] = visited[r][c][k] + 1;
					q.add(new int[] { nr, nc, k + 1 });
				}
			}

		}
	}
}
//https://www.acmicpc.net/problem/14442