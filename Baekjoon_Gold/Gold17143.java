import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold17143 {

	static Shark[][] map;
	static int[] reverseDir = { 1, 0, 3, 2 };
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int R, C, M, getShark;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		map = new Shark[R + 1][C];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken()) - 1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()) - 1;
			int z = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r, c, s, d, z);
		}

		for (int i = 0; i < C; i++) {
			int[] shark = catchShark(0, i);
			if (shark != null) {
				int r = shark[0];
				int c = shark[1];
				getShark += map[r][c].z;
				map[r][c] = null;
			}
			moveShark();
		}
		System.out.println(getShark);

	}

	static void moveShark() {

		Shark[][] tmp = new Shark[R + 1][C];
		Queue<Shark> q = new LinkedList<>();
		for (int i = 1; i <= R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != null) {
					int r = map[i][j].r;
					int c = map[i][j].c;
					int s = map[i][j].s;
					int d = map[i][j].d;
					int z = map[i][j].z;
					q.add(new Shark(r, c, s, d, z));
				}
			}
		}

		while (!q.isEmpty()) {
			Shark shark = q.poll();
			int r = shark.r;
			int c = shark.c;
			int s = shark.s;
			int d = shark.d;
			int z = shark.z;

			if (d == 0) {
				s %= (R - 1) * 2;
			} else if (d == 1) {
				s %= (R - 1) * 2;
			} else if (d == 2) {
				s %= (C - 1) * 2;
			} else if (d == 3) {
				s %= (C - 1) * 2;
			}
			for (int i = 0; i < s; i++) {
				if (r + dr[d] == 0 || r + dr[d] == R + 1 || c + dc[d] == -1 || c + dc[d] == C) {
					d = reverseDir[d];
					i--;
					continue;
				}
				r += dr[d];
				c += dc[d];
			}

			if (tmp[r][c] != null && tmp[r][c].z < z) {
				tmp[r][c] = new Shark(r, c, s, d, z);
			} else if (tmp[r][c] == null) {
				tmp[r][c] = new Shark(r, c, s, d, z);
			}

		}
		map = tmp;
	}

	static int[] catchShark(int r, int c) {
		r++;
		while (true) {
			if (r == R + 1)
				break;
			if (map[r][c] != null) {
				return new int[] { r, c };
			}
			r++;
		}
		return null;
	}

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;

		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
//https://www.acmicpc.net/problem/17143