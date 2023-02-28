import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver13901 {
	static int[][] map;
	static int[] dr, dc;
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = -1;
		}

		st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");

		dr = new int[4];
		dc = new int[4];

		for (int i = 0; i < 4; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == 1) {
				dr[i] = -1;
				dc[i] = 0;
			} else if (n == 2) {
				dr[i] = 1;
				dc[i] = 0;
			} else if (n == 3) {
				dr[i] = 0;
				dc[i] = -1;
			} else if (n == 4) {
				dr[i] = 0;
				dc[i] = 1;
			}
		}

		int r = sr;
		int c = sc;
		map[r][c] = 1;
		int d = 0;
		while (true) {

			if (!isPossible(r, c)) {
				System.out.println(r + " " + c);
				break;
			}

			r = r + dr[d];
			c = c + dc[d];

			if (r < 0 || r >= R || c < 0 || c >= C) {
				r -= dr[d];
				c -= dc[d];
				d = (d + 1) % 4;
				continue;
			}
			if (map[r][c] == 1 || map[r][c] == -1) {
				r -= dr[d];
				c -= dc[d];
				d = (d + 1) % 4;
				continue;
			}

			map[r][c] = 1;

//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}

		}

	}

	static boolean isPossible(int r, int c) {
		int cnt = 0;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if (map[nr][nc] == -1 || map[nr][nc] == 1)
				continue;
			cnt++;

		}
		if (cnt == 0)
			return false;
		else
			return true;
	}

}
//https://www.acmicpc.net/problem/13901