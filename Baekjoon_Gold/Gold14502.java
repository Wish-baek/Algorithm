import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold14502 {
	static int[][] map;
	static int max, N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = Integer.MIN_VALUE;

		setWall(0);
		System.out.println(max);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void setWall(int depth) {

		if (depth == 3) {
			spread();
			return;
		}

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (map[i][j] == 0) {
					map[i][j] = 1;
					setWall(depth + 1);
					map[i][j] = 0;
				}
	}

	static void spread() {
		int[][] newMap = new int[N][M];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				newMap[i][j] = map[i][j];

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (newMap[i][j] == 2)
					q.add(new int[] { i, j });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || newMap[nr][nc] != 0)
					continue;
				newMap[nr][nc] = 2;
				q.add(new int[] { nr, nc });
			}
		}
		calSafe(newMap);

	}

	static void calSafe(int[][] newMap) {
		int cnt = 0;
		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				if (newMap[i][j] == 0)
					cnt++;
		max = Math.max(max, cnt);
	}

}
//https://www.acmicpc.net/problem/14502