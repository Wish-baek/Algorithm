import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold2580 {
	static boolean[] number;
	static List<Point> list;
	static int[][] board;

	static class Point {
		int r;
		int c;

		public Point(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		board = new int[9][9];

		list = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 0)
					list.add(new Point(i, j));
			}
		}
		dfs(0);
		int r = 5;
		int c = 5;
//		for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
//			for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
//				System.out.print(board[i][j]);
//			}
//			System.out.println();
//		}
		number = new boolean[9];

	}

	static void dfs(int idx) {

		if (idx == list.size()) {
			for (int a = 0; a < 9; a++) {
				for (int b = 0; b < 9; b++) {
					System.out.print(board[a][b] + " ");
				}
				System.out.println();
			}
			System.exit(0);
			;
		}

		int r = list.get(idx).r;
		int c = list.get(idx).c;

		for (int i = 0; i < 9; i++) {
			if (!isPossible(r, c, i + 1))
				continue;

			board[r][c] = i + 1;
			dfs(idx + 1);
			board[r][c] = 0;

		}
	}

	static boolean isPossible(int r, int c, int n) {
		int ck = 0;
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == n && i != c) {
				ck++;
				break;
			}
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == n && i != r) {
				ck++;
				break;
			}
		}

		for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
			for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
				if (board[i][j] == n && i != r && j != c) {
					ck++;
					break;
				}

			}
		}

		if (ck > 0)
			return false;
		else
			return true;
	}

}
//https://www.acmicpc.net/problem/2580