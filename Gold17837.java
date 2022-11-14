import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold17837 {
	static boolean end, cannotEnd;
	static horse[] hList;
	static int[][] colorMap;
	static List<horse>[][] map;
	static int[] dr = { 0, 0, -1, 1 }; // 우좌상하
	static int[] dc = { 1, -1, 0, 0 };
	static int[] reverse = { 1, 0, 3, 2 };
	static int N, K;

	static class horse {
		int r;
		int c;
		int num;
		int d;

		public horse(int r, int c, int num, int d) {
			this.r = r;
			this.c = c;
			this.num = num;
			this.d = d;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		hList = new horse[K];
		colorMap = new int[N][N];
		map = new ArrayList[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				colorMap[i][j] = Integer.parseInt(st.nextToken());
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken()) - 1;
			int d = Integer.parseInt(st.nextToken()) - 1;
			hList[i] = new horse(r, c, i + 1, d);
			map[r][c].add(new horse(r, c, i + 1, d));
		}
		int turn = 1;
		while (true) {
			for (int k = 0; k < K; k++) {
				move(k);
			}
			if (end)
				break;
			turn++;
			if (turn >= 1001) {
				cannotEnd = true;
				break;
			}

		}
		if (cannotEnd)
			System.out.println(-1);
		else
			System.out.println(turn);
	}

	static void move(int horseNum) {
		horse h = hList[horseNum];
		int nr = h.r + dr[h.d];
		int nc = h.c + dc[h.d];
		if (nr < 0 || nr >= N || nc < 0 || nc >= N || colorMap[nr][nc] == 2) {
			hList[horseNum].d = reverse[h.d];
			h.d = hList[horseNum].d;
			for (int i = 0; i < map[h.r][h.c].size(); i++) {
				if (map[h.r][h.c].get(i).num == h.num) {
					map[h.r][h.c].get(i).d = h.d;
					break;
				}
			}

			nr = h.r + dr[h.d];
			nc = h.c + dc[h.d];
			if ((nr >= 0 && nr < N && nc >= 0 && nc < N) && colorMap[nr][nc] != 2) {
				if (colorMap[nr][nc] == 0) {
					int size = map[h.r][h.c].size();
					for (int i = 0; i < size; i++) {
						if (map[h.r][h.c].get(i).num == h.num) {
							int cnt = size - i;
							for (int j = 0; j < cnt; j++) {
								horse tmp = map[h.r][h.c].get(i);
								hList[tmp.num - 1] = new horse(nr, nc, tmp.num, tmp.d);
								map[nr][nc].add(new horse(nr, nc, tmp.num, tmp.d));
								map[h.r][h.c].remove(i);
								if (map[nr][nc].size() >= 4) {
									end = true;
									return;
								}
							}
							break;
						}
					}
				} else if (colorMap[nr][nc] == 1) {
					int size = map[h.r][h.c].size();
					for (int i = 0; i < size; i++) {
						if (map[h.r][h.c].get(i).num == h.num) {
							for (int j = size - 1; j >= i; j--) {
								horse tmp = map[h.r][h.c].get(j);
								hList[tmp.num - 1] = new horse(nr, nc, tmp.num, tmp.d);
								map[nr][nc].add(new horse(nr, nc, tmp.num, tmp.d));
								map[h.r][h.c].remove(map[h.r][h.c].size() - 1);
								if (map[nr][nc].size() >= 4) {
									end = true;
									return;
								}
							}

							break;
						}
					}
				}
			}
		} else if (colorMap[nr][nc] == 0) {
			int size = map[h.r][h.c].size();

			for (int i = 0; i < size; i++) {
				if (map[h.r][h.c].get(i).num == h.num) {
					int cnt = size - i;
					for (int j = 0; j < cnt; j++) {
						horse tmp = map[h.r][h.c].get(i);
						hList[tmp.num - 1] = new horse(nr, nc, tmp.num, tmp.d);
						map[nr][nc].add(new horse(nr, nc, tmp.num, tmp.d));
						map[h.r][h.c].remove(i);
						if (map[nr][nc].size() >= 4) {
							end = true;
							return;
						}
					}
					break;
				}
			}
		} else if (colorMap[nr][nc] == 1) {
			int size = map[h.r][h.c].size();
			for (int i = 0; i < size; i++) {
				if (map[h.r][h.c].get(i).num == h.num) {
					for (int j = size - 1; j >= i; j--) {
						horse tmp = map[h.r][h.c].get(j);
						hList[tmp.num - 1] = new horse(nr, nc, tmp.num, tmp.d);
						map[nr][nc].add(new horse(nr, nc, tmp.num, tmp.d));
						map[h.r][h.c].remove(map[h.r][h.c].size() - 1);
						if (map[nr][nc].size() >= 4) {
							end = true;
							return;
						}
					}
					break;
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/17837