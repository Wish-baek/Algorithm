import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1652 {
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		String str;
		int N = Integer.parseInt(br.readLine());
		map = new char[N][N];

		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		int row = 0;
		int col = 0;

		for (int i = 0; i < N; i++) {
			int row_cnt = 0;
			int col_cnt = 0;

			for (int j = 0; j < N; j++) {
				if (map[i][j] == '.') {
					row_cnt++;
				}
				if (map[i][j] == 'X' || j == N - 1) {
					if (row_cnt >= 2) {
						row++;
					}
					row_cnt = 0;
				}

				if (map[j][i] == '.') {
					col_cnt++;
				}
				if (map[j][i] == 'X' || j == N - 1) {
					if (col_cnt >= 2) {
						col++;
					}
					col_cnt = 0;
				}
			}

		}
		System.out.println(row + " " + col);
	}
}
//https://www.acmicpc.net/problem/1652