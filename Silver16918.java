import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver16918 {
	static char[][] map;
	static int[][] setBombTime;
	static int R, C;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		setBombTime = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);

			}
		}

		if (N == 1) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		} else {
			int time = 1;
			int turn = 1;
			while (true) {
//			System.out.println("turn: " + turn++);
				setBomb(time + 1);
				time++;
//			System.out.println(time);
//			System.out.println("set");
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(setBombTime[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();

//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
				if (time == N)
					break;
				time++;
				popBomb(time - 3);
//			System.out.println(time - 3);
//			System.out.println("pop");
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(setBombTime[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
//			System.out.println();
				if (time == N)
					break;
			}

			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	static void setBomb(int time) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
					setBombTime[i][j] = time;
				}
			}
		}
	}

	static void popBomb(int time) {
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (setBombTime[i][j] == time && map[i][j] == 'O')
					q.add(new int[] { i, j });
			}
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			map[r][c] = '.';
			setBombTime[r][c] = 0;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				map[nr][nc] = '.';
				setBombTime[nr][nc] = 0;
			}
		}
	}

}
//https://www.acmicpc.net/problem/16918