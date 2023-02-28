import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3085 {
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int N, max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int d = 0; d < 4; d++) {
					int nr = i + dr[d];
					int nc = j + dc[d];
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						continue;
					if (map[i][j] != map[nr][nc]) {
						char tmp = map[i][j];
						map[i][j] = map[nr][nc];
						map[nr][nc] = tmp;

						find();

						tmp = map[i][j];
						map[i][j] = map[nr][nc];
						map[nr][nc] = tmp;
					}
				}
			}
		}
		System.out.println(max);
	}

	static void find() {
		// 행검사
		for (int i = 0; i < N; i++) {
			char tmp = map[i][0];
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (map[i][j] == tmp)
					cnt++;
				else {
					max = Math.max(max, cnt);
					tmp = map[i][j];
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}

		// 열검사
		for (int i = 0; i < N; i++) {
			char tmp = map[0][i];
			int cnt = 1;
			for (int j = 1; j < N; j++) {
				if (map[j][i] == tmp)
					cnt++;
				else {
					max = Math.max(max, cnt);
					tmp = map[j][i];
					cnt = 1;
				}
			}
			max = Math.max(max, cnt);
		}
	}
}