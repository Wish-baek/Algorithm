import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2206 {
	static char[][] map;
	static boolean[][] visited, visited2;
	static int N, M, result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		visited2 = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		bfs();

		System.out.println(-1);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited[0][0] = true;
		q.offer(new int[] { 0, 0, 1, 0 });

		while (!q.isEmpty()) {

			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int dist = tmp[2];
			int cnt = tmp[3];

			if (r == N - 1 && c == M - 1 && cnt <= 1) {
				System.out.println(dist);
				System.exit(0);

			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M) {

					if (map[nr][nc] == '0') {
						if(cnt==0&&!visited[nr][nc]) {
							q.offer(new int[] { nr, nc, dist + 1, cnt });
							visited[nr][nc] = true;
						}
						else if (cnt>0&&!visited2[nr][nc]) {
							q.offer(new int[] { nr, nc, dist + 1, cnt});
							visited2[nr][nc] = true;

						}
					}

					else if (map[nr][nc] == '1') {
						if(cnt==0) {
							q.offer(new int[] { nr, nc, dist + 1, cnt+1 });
							visited2[nr][nc] = true;
						}

				}

			}
			}
		}

	}

}
