import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold8972 {
	static int[][] exist;
	static char[][] map;
	static int[] dr = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static int[] dc = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static int R, C, dir, jr, jc, ar, ac;
	static boolean endCk;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new char[R][C];

		jr = -1;
		jc = -1;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					jr = i;
					jc = j;
				}
			}
		}

		char[] oper = br.readLine().toCharArray();

		for (int i = 0; i < oper.length; i++) {
			dir = oper[i] - '0';

			Move();
			find();

			if (endCk) {
				System.out.println("kraj " + (i + 1));
				System.exit(0);
			}
		}

		for (int a = 0; a < R; a++) {
			for (int b = 0; b < C; b++) {
				System.out.print(map[a][b]);
			}
			System.out.println();
		}
		System.out.println();

	}

	static void Move() {
		map[jr][jc] = '.';
		jr += dr[dir];
		jc += dc[dir];
		if (map[jr][jc] == 'R') {
			endCk = true;
			return;
		}
		map[jr][jc] = 'I';
	}

	static void find() {
		exist = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'R') {
					moveCrazy(i, j);

				}
			}
		}
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (exist[i][j] > 1)
					map[i][j] = '.';
				else if (exist[i][j] == 1)
					map[i][j] = 'R';
				else
					map[i][j] = '.';
			}
		}

		map[jr][jc] = 'I';

	}

	static void moveCrazy(int r, int c) {

		int minDist = Integer.MAX_VALUE;
		int minR = -1;
		int minC = -1;

		for (int i = 1; i <= 9; i++) {
			if (i == 5)
				continue;
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			int dist = Math.abs(jr - nr) + Math.abs(jc - nc);
			if (dist < minDist) {
				minDist = dist;
				minR = nr;
				minC = nc;
			}
		}

		if (map[minR][minC] == 'I') {
			endCk = true;
		} else {
			exist[minR][minC]++;
		}
	}
}
//https://www.acmicpc.net/problem/8972