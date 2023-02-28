import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold20056 {

	static List<fireball>[][] map;
	static int N;

	static class fireball {
		int m;
		int s;
		int d;

		public fireball(int m, int s, int d) {
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
		int K = Integer.parseInt(st.nextToken()); // 명령 수

		map = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			map[r][c].add(new fireball(m, s, d));
		}

		for (int i = 0; i < K; i++) {
			move();
			split();
		}

		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (fireball fb : map[i][j]) {
					sum += fb.m;
				}
			}
		}
		System.out.println(sum);

	}

	static int[] dr = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dc = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static void move() {
		List<fireball>[][] tmp = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j].size() >= 1) {
					for (fireball fb : map[i][j]) {
						int dist = fb.s % N;
						int d = fb.d;
						int r = i + dist * dr[d];
						int c = j + dist * dc[d];
						if (r < 0)
							r += N;
						else if (r >= N)
							r -= N;
						if (c < 0)
							c += N;
						else if (c >= N)
							c -= N;
						tmp[r][c].add(new fireball(fb.m, fb.s, fb.d));

					}
				}
			}
		}

		map = tmp;
	}

	static void split() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				if (map[i][j].size() >= 2) {
					int mSum = 0;
					int sSum = 0;
					int oddSum = 0;
					int evenSum = 0;

					for (fireball fb : map[i][j]) {
						mSum += fb.m;
						sSum += fb.s;
						if (fb.d % 2 == 1)
							oddSum++;
						else if (fb.d % 2 == 0)
							evenSum++;
					}

					int m = mSum / 5;
					int s = sSum / map[i][j].size();

					map[i][j].clear();

					if (m == 0)
						continue;

					int tmp = 0;
					if (oddSum == map[i][j].size() || evenSum == map[i][j].size())
						tmp = 0;
					else
						tmp = 1;
					for (int k = tmp; k < tmp + 7; k += 2) {
						map[i][j].add(new fireball(m, s, k));
					}
				}

			}
		}
	}

}
//https://www.acmicpc.net/problem/20056