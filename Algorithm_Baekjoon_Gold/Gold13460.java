import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold13460 {
	static char[][] map;
	static int N, M, result;

	static class node {
		int r;
		int c;
		boolean in;

		public node(int r, int c, boolean in) {
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
		int holeR = -1;
		int holeC = -1;
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

		result = Integer.MAX_VALUE;
		dfs(redR, redC, blueR, blueC, false, false, 0, -1);
		if (result == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(result);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int redR, int redC, int blueR, int blueC, boolean redIn, boolean blueIn, int cnt, int d) {
		if (cnt >= 11)
			return;

		if (redIn && !blueIn) {
			result = Math.min(result, cnt);
			return;
		} else if (blueIn) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (d == i)
				continue;
			if ((i == 0 && redR < blueR) || (i == 1 && redR > blueR) || (i == 2 && redC < blueC)
					|| (i == 3 && redC > blueC)) {

				node red = move(redR, redC, i);
				if (!red.in)
					map[red.r][red.c] = 'R';

				node blue = move(blueR, blueC, i);
				if (!blue.in)
					map[blue.r][blue.c] = 'R';

				dfs(red.r, red.c, blue.r, blue.c, red.in, blue.in, cnt + 1, i);

				map[redR][redC] = 'R';
				if (!red.in)
					map[red.r][red.c] = '.';
				map[blueR][blueC] = 'B';
				if (!blue.in)
					map[blue.r][blue.c] = '.';

			} else {
//				System.out.println(i);
				node blue = move(blueR, blueC, i);
				if (!blue.in)
					map[blue.r][blue.c] = 'R';

				node red = move(redR, redC, i);
				if (!red.in)
					map[red.r][red.c] = 'R';

				dfs(red.r, red.c, blue.r, blue.c, red.in, blue.in, cnt + 1, i);

				map[blueR][blueC] = 'B';
				if (!blue.in)
					map[blue.r][blue.c] = '.';

				map[redR][redC] = 'R';
				if (!red.in)
					map[red.r][red.c] = '.';
			}
		}
	}

	static node move(int sr, int sc, int d) {
		boolean in = false;
		int r = sr;
		int c = sc;
		while (true) {
			r += dr[d];
			c += dc[d];
			if (map[r][c] == 'O') {
				in = true;
				break;
			}
			if (map[r][c] != '.')
				break;
		}
		map[sr][sc] = '.';
		if (!in) {
			r -= dr[d];
			c -= dc[d];
		}
		return new node(r, c, in);
	}
}
//https://www.acmicpc.net/problem/13460