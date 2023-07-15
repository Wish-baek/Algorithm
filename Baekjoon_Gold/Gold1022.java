import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold1022 {
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int r1 = Integer.parseInt(st.nextToken());
		int c1 = Integer.parseInt(st.nextToken());
		int r2 = Integer.parseInt(st.nextToken());
		int c2 = Integer.parseInt(st.nextToken());
		int rSize = r2 - r1 + 1;
		int cSize = c2 - c1 + 1;

		int[][] map = new int[rSize][cSize];
		int num = 1;
		int r = 0;
		int c = 0;
		int repeat = 0;
		int maxLen = 1;

		if (r1 <= r && r <= r2 && c1 <= c && c <= c2) {
			map[r - r1][c - c1] = 1;
		}

		loop: while (true) {
			for (int i = 0; i < 4; i++) {
				if (i == 0 || i == 2)
					repeat++;
				for (int j = 0; j < repeat; j++) {
					r += dr[i];
					c += dc[i];

					if (r < -5000 || r > 5000 || c < -5000 || c > 5000)
						break loop;

					num++;

					if (r1 <= r && r <= r2 && c1 <= c && c <= c2) {
						map[r - r1][c - c1] = num;
						maxLen = Math.max(maxLen, map[r - r1][c - c1]);
					}

				}
			}
		}

		for (int i = 0; i < rSize; i++) {
			for (int j = 0; j < cSize; j++) {
				int diff = Integer.toString(maxLen).length() - Integer.toString(map[i][j]).length();
				for (int k = 0; k < diff; k++) {
					sb.append(" ");
				}
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}

// https://www.acmicpc.net/problem/1022