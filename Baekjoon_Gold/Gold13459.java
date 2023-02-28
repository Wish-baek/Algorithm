import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold13459 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] reverse = { 1, 0, 3, 2 };
	static char[][] map;
	static int N, M, holeR, holeC, result;

	static class info {
		int r;
		int c;
		boolean in;

		public info(int r, int c, boolean in) {
			this.r = r;
			this.c = c;
			this.in = in;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		int redR = -1;
		int redC = -1;
		int blueR = -1;
		int blueC = -1;
		holeR = -1;
		holeC = -1;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					redR = i;
					redC = j;
				} else if (map[i][j] == 'B') {
					blueR = i;
					blueC = j;
				} else if (map[i][j] == 'O') {
					holeR = i;
					holeC = j;
				}
			}
		}

		dfs(redR, redC, blueR, blueC, false, false, -1, 0);
		System.out.println(0);
	}

	static void dfs(int redR, int redC, int blueR, int blueC, boolean redIn, boolean blueIn, int d, int cnt) {

		if (cnt >= 11)
			return;

		if (redIn && !blueIn) {
			System.out.println(1);
			System.exit(0);
		} else if (blueIn) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (d == i)
				continue;
			if ((i == 0 && redR < blueR) || (i == 1 && redR > blueR) || (i == 2 && redC < blueC)
					|| (i == 3 && redC > blueC)) {

				int rr = redR;
				int rc = redC;
				int br = blueR;
				int bc = blueC;

				info red = move(redR, redC, i, 'R');
				info blue = move(blueR, blueC, i, 'B');

				dfs(red.r, red.c, blue.r, blue.c, red.in, blue.in, i, cnt + 1);
				map[rr][rc] = 'R';
				if (red.in)
					map[red.r][red.c] = 'O';
				else
					map[red.r][red.c] = '.';

				map[br][bc] = 'B';
				if (blue.in)
					map[blue.r][blue.c] = 'O';
				else
					map[blue.r][blue.c] = '.';
			}

			else {
				int rr = redR;
				int rc = redC;
				int br = blueR;
				int bc = blueC;

				info blue = move(blueR, blueC, i, 'B');
				info red = move(redR, redC, i, 'R');

				dfs(red.r, red.c, blue.r, blue.c, red.in, blue.in, i, cnt + 1);
				map[rr][rc] = 'R';
				if (red.in)
					map[red.r][red.c] = 'O';
				else
					map[red.r][red.c] = '.';

				map[br][bc] = 'B';
				if (blue.in)
					map[blue.r][blue.c] = 'O';
				else
					map[blue.r][blue.c] = '.';
			}
		}
	}

	static info move(int sr, int sc, int d, char color) {
		int r = sr;
		int c = sc;
		boolean in = false;
		while (true) {
			r += dr[d];
			c += dc[d];
			if (map[r][c] == 'O') {
				in = true;
				break;
			}
			if (map[r][c] == '#' || map[r][c] == 'R' || map[r][c] == 'B')
				break;
		}
		if (!in) {
			r -= dr[d];
			c -= dc[d];
		}

		map[sr][sc] = '.';
		if (!in) {
			map[r][c] = color;
		}
		return new info(r, c, in);
	}
}
//https://www.acmicpc.net/problem/13459