import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold23288 {
	static int[][] map;
	static int[] dr = { 0, 1, 0, -1 }; // 동남서북 == 우하좌상
	static int[] dc = { 1, 0, -1, 0 };
	static int[] reverse = { 2, 3, 0, 1 };
	static int[] dice = { 0, 1, 2, 3, 4, 5, 6 };
	static int N, M, r, c, d, score, bottom;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < K; k++) {
			move();
		}

		System.out.println(score);
	}

	private static void move() {
		int nr = r + dr[d];
		int nc = c + dc[d];
		if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
			d = reverse[d];
		}
		r += dr[d];
		c += dc[d];
		if (d == 0) {
			int tmp = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = tmp;
		} else if (d == 1) {
			int tmp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = tmp;
		} else if (d == 2) {
			int tmp = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = tmp;
		} else if (d == 3) {
			int tmp = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = tmp;
		}

		int bottom = dice[6];
		if (bottom > map[r][c])
			d = (d + 1) % 4;
		else if (bottom < map[r][c])
			d = d - 1 < 0 ? d - 1 + 4 : d - 1;
		score += map[r][c] * bfs(r, c, map[r][c]);
	}

	static int bfs(int sr, int sc, int num) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		int cnt = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visited[nr][nc] || map[nr][nc] != num)
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				cnt++;
			}
		}
		return cnt;
	}
}
//https://www.acmicpc.net/problem/23288