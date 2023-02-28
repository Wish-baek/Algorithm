import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1600 {
	static int[][] map;
	static int[][][] visited;
	static int w, h, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][w];
		visited = new int[h][w][K + 1];

		for (int i = 0; i < h; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < w; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0, 0);
		int min = Integer.MAX_VALUE;
		for (int i = 0; i <= K; i++) {
			if (visited[h - 1][w - 1][i] != 0)
				min = Math.min(min, visited[h - 1][w - 1][i]);
		}

		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min - 1);

	}

	static int[] m_dr = { -1, 1, 0, 0 };
	static int[] m_dc = { 0, 0, -1, 1 };
	static int[] h_dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] h_dc = { -2, -1, 1, 2, -2, -1, 1, 2 };

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { sr, sc, 0 });
		for (int i = 0; i <= K; i++) {
			visited[0][0][i] = 1;
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int k = tmp[2];

			for (int i = 0; i < 4; i++) {
				int nr = r + m_dr[i];
				int nc = c + m_dc[i];

				if (nr < 0 || nr >= h || nc < 0 || nc >= w)
					continue;
				if (map[nr][nc] == 1) {
					continue;
				}
				if (visited[nr][nc][k] != 0) {

					continue;
				}
				visited[nr][nc][k] = visited[r][c][k] + 1;
				q.add(new int[] { nr, nc, k });
			}

			if (k < K) {
				for (int i = 0; i < 8; i++) {
					int nr = r + h_dr[i];
					int nc = c + h_dc[i];
					if (nr < 0 || nr >= h || nc < 0 || nc >= w)
						continue;
					if (visited[nr][nc][k + 1] != 0 || map[nr][nc] == 1)
						continue;
					visited[nr][nc][k + 1] = visited[r][c][k] + 1;
					q.add(new int[] { nr, nc, k + 1 });
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/1600