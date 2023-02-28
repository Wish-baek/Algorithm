import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver14716 {
	static int[][] map;
	static boolean[][] visited;
	static int M, N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];
		visited = new boolean[M][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					visited[i][j] = true;
					bfs(i, j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}

	static int[] dr = { -1, 1, -1, 1, 0, 0, -1, 1 };
	static int[] dc = { 1, -1, -1, 1, -1, 1, 0, 0 };

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= M || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] || map[nr][nc] == 0)
					continue;
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}

		}

	}

}
//https://www.acmicpc.net/problem/14716