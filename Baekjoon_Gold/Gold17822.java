import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold17822 {
	static boolean[][] isRemove;
	static int[][] map;
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isRemove = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			for (int i = 1; i < N; i++) { // 회전시키기
				if ((i + 1) % x == 0) {
					rotate(i, d, k);
				}
			}

			// ------------인접하면서 같은 수 있는지 찾기------------

			boolean[][] tmp = new boolean[N][M];
			boolean ck = false;

			for (int i = 0; i < N; i++) { // 같은 원판끼리 찾기
				for (int j = 0; j < M; j++) {
					if (!isRemove[i][j] && !isRemove[i][(j + 1) % M] && map[i][j] == map[i][(j + 1) % M]) { // 같은 수라면
						tmp[i][j] = true;
						tmp[i][(j + 1) % M] = true;
						ck = true;
					}
				}
			}
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < M; j++) { // 인접한 원판끼리 찾기
					if (!isRemove[i][j] && !isRemove[i - 1][j] && map[i][j] == map[i - 1][j]) {
						tmp[i][j] = true;
						tmp[i - 1][j] = true;
						ck = true;
					}
					if (i + 1 < N && !isRemove[i][j] && !isRemove[i + 1][j] && map[i][j] == map[i + 1][j]) {
						tmp[i][j] = true;
						tmp[i + 1][j] = true;
						ck = true;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tmp[i][j])
						isRemove[i][j] = true;
				}
			}

			if (ck) {
				continue;
			}

			// ------------인접하면서 같은 수가 없다면------------
			int sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!isRemove[i][j]) {
						sum += map[i][j];
						cnt++;
					}
				}
			}
			if (cnt == 0) {
				continue;
			}

			double avg = (double) sum / cnt;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!isRemove[i][j]) {
						int n = map[i][j];
						if (n > avg) {
							map[i][j]--;
						}

						else if (n < avg) {
							map[i][j]++;
						}
					}
				}
			}
		}

		int result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!isRemove[i][j])
					result += map[i][j];
			}
		}
		System.out.println(result);

	}

	static void rotate(int r, int d, int k) {
		if (d == 0) {
			for (int j = 0; j < k; j++) {
				boolean tmpb = isRemove[r][M - 1];
				int tmp = map[r][M - 1];
				for (int i = M - 1; i >= 1; i--) {
					map[r][i] = map[r][i - 1];
					isRemove[r][i] = isRemove[r][i - 1];
				}
				map[r][0] = tmp;
				isRemove[r][0] = tmpb;

			}
		} else if (d == 1) {
			for (int j = 0; j < k; j++) {
				boolean tmpb = isRemove[r][0];
				int tmp = map[r][0];
				for (int i = 0; i < M - 1; i++) {
					map[r][i] = map[r][i + 1];
					isRemove[r][i] = isRemove[r][i + 1];
				}
				map[r][M - 1] = tmp;
				isRemove[r][M - 1] = tmpb;
			}
		}
	}
}
//https://www.acmicpc.net/problem/14391