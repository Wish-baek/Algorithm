import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver5212 {
	static char[][] map;
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		melt();
		int r_min = Integer.MAX_VALUE;
		int r_max = -1;
		int c_min = Integer.MAX_VALUE;
		int c_max = -1;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'X') {
					r_min = Math.min(r_min, i);
					r_max = Math.max(r_max, i);
					c_min = Math.min(c_min, j);
					c_max = Math.max(c_max, j);
				}
			}
		}

		for (int i = r_min; i <= r_max; i++) {
			for (int j = c_min; j <= c_max; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

	}

	static void melt() {
		char[][] tmp = new char[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tmp[i][j] = map[i][j];
			}
		}

		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				int cnt = 0;
				if (tmp[r][c] != 'X')
					continue;
				if (r - 1 < 0 || (r - 1 >= 0 && tmp[r - 1][c] == '.'))
					cnt++;
				if (r + 1 >= R || (r + 1 < R && tmp[r + 1][c] == '.'))
					cnt++;
				if (c - 1 < 0 || (c - 1 >= 0 && tmp[r][c - 1] == '.'))
					cnt++;
				if (c + 1 >= C || (c + 1 < C && tmp[r][c + 1] == '.'))
					cnt++;
				if (cnt >= 3)
					map[r][c] = '.';
			}
		}
	}
}
//https://www.acmicpc.net/problem/5212