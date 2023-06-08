import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver26169 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		map = new int[5][5];

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());

		map[sr][sc] = -1;
		dfs(sr, sc, 0, 0);
		System.out.println(0);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int moveCnt, int appleCnt) {

		if (moveCnt > 3)
			return;

		if (appleCnt >= 2) {
			System.out.println(1);
			System.exit(0);
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
				continue;

			if (map[nr][nc] == -1)
				continue;

			if (map[nr][nc] == 1) {
				map[nr][nc] = -1;
				dfs(nr, nc, moveCnt + 1, appleCnt + 1);
				map[nr][nc] = 1;

			} else if (map[nr][nc] == 0) {
				map[nr][nc] = -1;
				dfs(nr, nc, moveCnt + 1, appleCnt);
				map[nr][nc] = 0;

			}
		}
	}
}
// https://www.acmicpc.net/problem/26169
