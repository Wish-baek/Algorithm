import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold16197 {
	static int N, M, result;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		int r1 = -1;
		int c1 = -1;
		int r2 = -1;
		int c2 = -1;

		boolean ck = false;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'o') {
					if (!ck) {
						r1 = i;
						c1 = j;
						ck = true;
					} else {
						r2 = i;
						c2 = j;
					}
				}
			}
		}

		result = Integer.MAX_VALUE;
		dfs(r1, c1, r2, c2, 1);
		if (result > 10 || result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r1, int c1, int r2, int c2, int cnt) {

		if (cnt >= 10 || cnt >= result)
			return;

		for (int i = 0; i < 4; i++) {
			int ck = 0;

			int nr1 = r1 + dr[i];
			int nc1 = c1 + dc[i];
			int nr2 = r2 + dr[i];
			int nc2 = c2 + dc[i];

			if (nr1 < 0 || nr1 >= N || nc1 < 0 || nc1 >= M)
				ck++;
			if (nr2 < 0 || nr2 >= N || nc2 < 0 || nc2 >= M)
				ck++;

			if (ck == 2)
				continue;

			if (ck == 1) {
				result = Math.min(result, cnt);
				return;
			}
			if (map[nr1][nc1] == '#') {
				nr1 = r1;
				nc1 = c1;
			}

			if (map[nr2][nc2] == '#') {
				nr2 = r2;
				nc2 = c2;
			}

			dfs(nr1, nc1, nr2, nc2, cnt + 1);
		}
	}
}
//https://www.acmicpc.net/problem/16197