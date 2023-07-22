import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold27211 {

	static int N, M;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0 && !visited[i][j]) {
					bfs(i, j);
					result++;
				}
			}
		}
		System.out.println(result);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });

		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				nr = nr < 0 ? N - 1 : nr >= N ? 0 : nr;
				int nc = c + dc[i];
				nc = nc < 0 ? M - 1 : nc >= M ? 0 : nc;

				if (map[nr][nc] == 1 || visited[nr][nc])
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}

// https://www.acmicpc.net/problem/27211