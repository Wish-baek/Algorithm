import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1303 {
	static char[][] map;
	static boolean[][] visited_all;
	static int cnt, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited_all = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		int W = 0;
		int B = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				cnt = 0;
				if (!visited_all[i][j] && map[i][j] == 'W') {
					visited_all[i][j] = true;
					bfs(i, j, 'W');
					W += Math.pow(cnt, 2);
				} else if (!visited_all[i][j] && map[i][j] == 'B') {
					visited_all[i][j] = true;
					bfs(i, j, 'B');
					B += Math.pow(cnt, 2);
				}

			}
		}
		System.out.println(W + " " + B);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc, char a) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		
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
				if (visited_all[nr][nc] || map[nr][nc] != a)
					continue;
				visited_all[nr][nc] = true;
				q.add(new int[] { nr, nc });

			}

		}

	}

	static void dfs(int sr, int sc, char a) {
		if (sr < 0 || sr >= N || sc < 0 || sc >= M || visited_all[sr][sc] || map[sr][sc] != a)
			return;
		visited_all[sr][sc] = true;
		cnt++;

		for (int i = 0; i < 4; i++) {
			int nr = sr + dr[i];
			int nc = sc + dc[i];

			dfs(nr, nc, a);

		}

	}
}
//https://www.acmicpc.net/problem/1303