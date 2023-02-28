import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold20057 {
	static int[][] map;
	static int N, result;
	static int[] dr = { 0, 1, 0, -1 };
	static int[] dc = { -1, 0, 1, 0 };
	static int[][][] dir = { { { 0, -2, -1, -1, -1, 0, 1, 1, 1, 2 }, // 왼쪽으로 이동할 때 행 좌표
			{ -1, 0, -1, 0, 1, -2, -1, 0, 1, 0 }, // 왼쪽으로 이동할 때 열 좌표
			{ 0, 2, 10, 7, 1, 5, 10, 7, 1, 2 } },

			{ { 1, -1, -1, 0, 0, 0, 0, 1, 1, 2 }, // 아래쪽으로 이동할 때 행 좌표
					{ 0, -1, 1, -2, -1, 1, 2, -1, 1, 0 }, // 아래쪽으로 이동할 때 열 좌표
					{ 0, 1, 1, 2, 7, 7, 2, 10, 10, 5 } },

			{ { 0, -2, -1, -1, -1, 0, 1, 1, 1, 2 }, // 오른쪽으로 이동할 때 행 좌표
					{ 1, 0, -1, 0, 1, 2, -1, 0, 1, 0 }, // 오른쪽으로 이동할 때 열 좌표
					{ 0, 2, 1, 7, 10, 5, 1, 7, 10, 2 } },

			{ { -1, -2, -1, -1, 0, 0, 0, 0, 1, 1 }, // 위쪽으로 이동할 때 행 좌표
					{ 0, 0, -1, 1, -2, -1, 1, 2, -1, 1 }, // 위쪽으로 이동할 때 열 좌표
					{ 0, 5, 10, 10, 2, 7, 7, 2, 1, 1 } } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int r = N / 2;
		int c = N / 2;
		int repeat = 1;

		loop: while (true) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < repeat; j++) {
					r += dr[i];
					c += dc[i];
					double send = map[r][c];

					scatter(r, c, i, send);
					map[r][c] = 0;
					if (r == 0 && c == 0)
						break loop;
				}
				if (i == 1 || i == 3)
					repeat++;
			}
		}
		System.out.println(result);
	}

	static void scatter(int r, int c, int d, double original) {
		double total = original;
		for (int i = 1; i < 10; i++) {
			int dr = dir[d][0][i];
			int dc = dir[d][1][i];

			double send = (original / 100) * dir[d][2][i];
			if (r + dr < 0 || r + dr >= N || c + dc < 0 || c + dc >= N) {
				result += (int) send;
			} else {
				map[r + dr][c + dc] += (int) send;
			}
			total -= (int) send;
		}

		int dr = dir[d][0][0];
		int dc = dir[d][1][0];
		if (r + dr < 0 || r + dr >= N || c + dc < 0 || c + dc >= N) {
			result += (int) total;
		} else
			map[r + dr][c + dc] += (int) total;
	}
}
//https://www.acmicpc.net/problem/20057