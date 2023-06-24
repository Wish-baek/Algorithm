import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1347 {

	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int min_r = 50;
		int min_c = 50;
		int max_r = 50;
		int max_c = 50;

		int r = 50;
		int c = 50;

		boolean[][] map = new boolean[101][101];
		map[r][c] = true;
		String str = br.readLine();
		int dir = 2;

		for (int i = 0; i < N; i++) {
			char ch = str.charAt(i);
			if (ch == 'L')
				dir = dir - 1 < 0 ? 3 : dir - 1;
			else if (ch == 'R')
				dir = dir + 1 > 3 ? 0 : dir + 1;
			else if (ch == 'F') {
				r += dr[dir];
				c += dc[dir];

			}

			min_r = Math.min(min_r, r);
			min_c = Math.min(min_c, c);
			max_r = Math.max(max_r, r);
			max_c = Math.max(max_c, c);
			map[r][c] = true;
		}

		for (int i = min_r; i <= max_r; i++) {
			for (int j = min_c; j <= max_c; j++) {
				System.out.print(map[i][j] ? "." : "#");
			}
			System.out.println();
		}
	}
}
//https://www.acmicpc.net/problem/1347