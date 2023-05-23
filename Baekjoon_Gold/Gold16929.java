import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold16929 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static boolean result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, i, j, 1);
			}
		}
		System.out.println("No");
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int sr, int sc, int r, int c, int cnt) {

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;

			if (nr == sr && nc == sc && cnt >= 3) {
				System.out.println("Yes");
				System.exit(0);
			}

			if (visited[nr][nc] || map[r][c] != map[nr][nc])
				continue;
			visited[nr][nc] = true;
			dfs(sr, sc, nr, nc, cnt + 1);
			visited[nr][nc] = false;
		}
	}
}
////https://www.acmicpc.net/problem/16929