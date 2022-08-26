import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold17144 {
	static int R, C, Ac_head, Ac_tail;
	private static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		Ac_tail = -1;

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == -1) {
					Ac_tail = i;
				}
			}
		}
		Ac_head = Ac_tail - 1;

		for (int i = 0; i < T; i++) {
			spread();
			move();
		}

//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0)
					result += map[i][j];
			}
		}
		System.out.println(result);

	}

	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	static void spread() {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1 || map[i][j] == 0)
					continue;
				q.add(new int[] { i, j, map[i][j] });
			}
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			int dust = tmp[2];
			if (dust < 5)
				continue;

			int val = dust / 5;
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (map[nr][nc] == -1)
					continue;
				map[nr][nc] += val;

				++cnt;

			}
			map[r][c] -= val * cnt;
		}
	}

	static void move() {
		int tmp00 = map[0][0];
		int tmpr0 = map[Ac_head][0];
		int tmprc = map[Ac_head][C - 1];
		int tmp0c = map[0][C - 1];

		// 반시계 방향 회전
		for (int i = Ac_head - 1; i >= 1; i--) { // 왼쪽
			map[i][0] = map[i - 1][0];
		}
		for (int i = C - 1; i >= 1; i--) { // 아래쪽
			map[Ac_head][i] = map[Ac_head][i - 1];
			if (map[Ac_head][i] == -1)
				map[Ac_head][i] = 0;
		}
		for (int i = 0; i < Ac_head - 1; i++) { // 오른쪽
			map[i][C - 1] = map[i + 1][C - 1];
		}
		for (int i = 0; i < C - 1; i++) { // 위쪽
			map[0][i] = map[0][i + 1];
		}
		map[0][C - 2] = tmp0c;
		if(Ac_head!=0)map[Ac_head - 1][C - 1] = tmprc;
		

		int tmp200 = map[Ac_tail][0]; // 좌상
		//int tmp20c = map[0][R - 1]; // 좌하
		int tmp2rc = map[R - 1][C - 1]; // 우하
		int tmp2r0 = map[Ac_tail][C - 1]; // 우상

		// 시계 방향 회전
		for (int i = Ac_tail + 1; i < R - 1; i++) { // 왼쪽
			map[i][0] = map[i + 1][0];
		}
		for (int i = C - 1; i >= 1; i--) { // 위쪽
			map[Ac_tail][i] = map[Ac_tail][i - 1];
			if (map[Ac_tail][i] == -1)
				map[Ac_tail][i] = 0;
		}

		for (int i = R - 1; i > Ac_tail; i--) { // 오른쪽
			map[i][C - 1] = map[i - 1][C - 1];
		}

		for (int i = 0; i < C - 1; i++) { // 아래쪽
			map[R - 1][i] = map[R - 1][i + 1];
		}
		if(Ac_tail!=R-1)map[Ac_tail + 1][C - 1] = tmp2r0;
		map[R - 1][C - 2] = tmp2rc;

	}

}
//https://www.acmicpc.net/problem/17144