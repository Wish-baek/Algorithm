import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16933 {
	static int[][] map;
	static int N, M, K, min;
	static boolean[][][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		min = Integer.MAX_VALUE;
		bfs();
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 0, 1, 1 });
		visited[0][0][0] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int cnt = tmp[2];
			int status = tmp[3];
			int time = tmp[4];
			if (r == N - 1 && c == M - 1) {
				min = Math.min(min, time);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;

				if (cnt == K) {
					if (map[nr][nc] == 0 && !visited[nr][nc][cnt]) {
						q.add(new int[] { nr, nc, cnt, status * -1, time + 1 });
						visited[nr][nc][cnt] = true;
					}
				} else if (cnt < K) {
					if (map[nr][nc] == 0 && !visited[nr][nc][cnt]) {
						q.add(new int[] { nr, nc, cnt, status * -1, time + 1 });
						visited[nr][nc][cnt] = true;
					} else if (map[nr][nc] == 1 && !visited[nr][nc][cnt + 1]) {
						if (status == 1) {
							q.add(new int[] { nr, nc, cnt + 1, status * -1, time + 1 });
							visited[nr][nc][cnt + 1] = true;
						} else if (status == -1) {
							q.add(new int[] { r, c, cnt, status * -1, time + 1 });
							visited[r][c][cnt] = true;
						}
					}
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/16933