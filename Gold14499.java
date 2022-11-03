import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold14499 {
	static int[][] map;
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static int[] dice;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dice = new int[7];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < K; i++) {
			int dir = Integer.parseInt(st.nextToken());
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if (nr < 0 || nr >= N || nc < 0 || nc >= M)
				continue;

			r += dr[dir];
			c += dc[dir];
			move(dir);
			if (map[r][c] == 0)
				map[r][c] = dice[6];
			else {
				dice[6] = map[r][c];
				map[r][c] = 0;
			}
			System.out.println(dice[1]);
		}

	}

	static void move(int dir) {

		if (dir == 1) {
			int tmp = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = tmp;
		} else if (dir == 2) {
			int tmp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = tmp;
		} else if (dir == 3) {
			int tmp = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = tmp;
		} else if (dir == 4) {
			int tmp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = tmp;
		}
	}
}
//https://www.acmicpc.net/problem/14499