import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold12100 {
	static info[][] map_1;
	static int N, result;

	static class info {
		int num;
		boolean combine;

		public info(int num, boolean combine) {
			this.num = num;
			this.combine = combine;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public void setCombine(boolean combine) {
			this.combine = combine;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		map_1 = new info[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				int n = Integer.parseInt(st.nextToken());
				map_1[i][j] = new info(n, false);

			}
		}

//		move(map_1, 0);
//		for (int a = 0; a < N; a++) {
//			for (int b = 0; b < N; b++) {
//				System.out.print(map_1[a][b].num + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		move(map_1, 3);
//		for (int a = 0; a < N; a++) {
//			for (int b = 0; b < N; b++) {
//				System.out.print(map_1[a][b].num + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		move(map_1, 3);
//		for (int a = 0; a < N; a++) {
//			for (int b = 0; b < N; b++) {
//				System.out.print(map_1[a][b].num + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		move(map_1, 3);
//		for (int a = 0; a < N; a++) {
//			for (int b = 0; b < N; b++) {
//				System.out.print(map_1[a][b].num + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		move(map_1, 3);
//		
//		for (int a = 0; a < N; a++) {
//			for (int b = 0; b < N; b++) {
//				System.out.print(map_1[a][b].num + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();

		int[] output = new int[5];
		comb(output, 5, 0);
		System.out.println(result);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void comb(int[] output, int c, int depth) {
		if (depth == c) {
//			System.out.println(Arrays.toString(output));
			info[][] tmp = new info[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int num = map_1[i][j].num;
					boolean combine = map_1[i][j].combine;

					tmp[i][j] = new info(num, combine);
				}
			}

			for (int i = 0; i < 5; i++) {
				tmp = move(tmp, output[i]);
				int max = cal(tmp);

				result = Math.max(result, cal(tmp));
			}

			return;
		}
		for (int i = 0; i < 4; i++) {
			output[depth] = i;
			comb(output, c, depth + 1);
		}
	}

	static info[][] move(info[][] map, int dir) {

		if (dir == 0) { // 상
			for (int i = 1; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].num == 0)
						continue;

					int r = i;
					int c = j;

					while (true) {
						int nr = r + dr[0];
						int nc = c + dc[0];
						if (nr < 0)
							break;

						if (map[nr][nc].num == 0) {
							map[nr][nc].setNum(map[r][c].num);
							map[nr][nc].setCombine(false);
							map[r][c].setNum(0);
							map[r][c].setCombine(false);
							r = nr;
							c = nc;
						}

						else if (map[nr][nc].num == map[r][c].num && !map[nr][nc].combine && !map[r][c].combine) {
							map[nr][nc].setNum(map[nr][nc].num * 2);
							map[nr][nc].setCombine(true);
							map[r][c].setNum(0);
							map[r][c].setCombine(false);

							break;
						}

						else {
							break;
						}
					}

				}
			}

		} else if (dir == 1) { // 하
			int cnt = 1;
			for (int i = N - 2; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					if (map[i][j].num == 0)
						continue;

					int r = i;
					int c = j;

					while (true) {
						int nr = r + dr[1];
						int nc = c + dc[1];
						if (nr >= N)
							break;
						if (map[nr][nc].num == 0) {
							map[nr][nc].setNum(map[r][c].num);
							map[nr][nc].setCombine(false);
							map[r][c].setNum(0);
							map[r][c].setCombine(false);
							r = nr;
							c = nc;
						}

						else if (map[nr][nc].num == map[r][c].num && !map[nr][nc].combine && !map[r][c].combine) {
							map[nr][nc].setNum(map[nr][nc].num * 2);
							map[nr][nc].setCombine(true);
							map[r][c].setNum(0);
							map[r][c].setCombine(false);
							break;
						}

						else {
							break;
						}

					}

				}
			}
		} else if (dir == 2) { // 좌
			for (int i = 0; i < N; i++) {
				for (int j = 1; j < N; j++) {
					if (map[i][j].num == 0)
						continue;

					int r = i;
					int c = j;

					while (true) {
						int nr = r + dr[2];
						int nc = c + dc[2];
						if (nc < 0)
							break;

						if (map[nr][nc].num == 0) {
							map[nr][nc].setNum(map[r][c].num);
							map[nr][nc].setCombine(false);
							map[r][c].setNum(0);
							map[r][c].setCombine(false);
							r = nr;
							c = nc;
						}

						else if (map[nr][nc].num == map[r][c].num && !map[nr][nc].combine && !map[r][c].combine) {
							map[nr][nc].setNum(map[nr][nc].num * 2);
							map[nr][nc].setCombine(true);
							map[r][c].setNum(0);
							map[r][c].setCombine(false);
							break;
						}

						else {
							break;
						}

					}

				}
			}
		} else if (dir == 3) { // 우
			for (int i = 0; i < N; i++) {
				for (int j = N - 2; j >= 0; j--) {
					if (map[i][j].num == 0)
						continue;

					int r = i;
					int c = j;

					while (true) {
						int nr = r + dr[3];
						int nc = c + dc[3];
						if (nc >= N)
							break;

						if (map[nr][nc].num == 0) {
							map[nr][nc].setNum(map[r][c].num);
							map[nr][nc].setCombine(false);
							map[r][c].setNum(0);
							map[r][r].setCombine(false);
							r = nr;
							c = nc;
						}

						else if (map[nr][nc].num == map[r][c].num && !map[nr][nc].combine && !map[r][c].combine) {
							map[nr][nc].setNum(map[nr][nc].num * 2);
							map[nr][nc].setCombine(true);

							map[r][c].setNum(0);
							map[r][c].setCombine(false);
							break;
						}

						else {
							break;
						}

					}

				}
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j].setCombine(false);
			}
		}
		return map;
	}

	static int cal(info[][] tmp) {
		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, tmp[i][j].num);
			}
		}
		if (max == 256) {

		}
		return max;
	}
}
//https://www.acmicpc.net/problem/12100