import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2468 {
	static int[][] map;
	static boolean[][] sink, visited;
	static int N, max;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		int maxNum = -1;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxNum = Math.max(maxNum, map[i][j]);
			}
		}
		max = Integer.MIN_VALUE;
		for (int i = 1; i < maxNum; i++) {
			flood(i);
		}
		if (max == Integer.MIN_VALUE)
			System.out.println(map[0][0]);
		else
			System.out.println(max);

	}

	static void flood(int n) {
		sink = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] <= n)
					sink[i][j] = true;
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!sink[i][j]) {
					calSafe(i, j);
					cnt++;
				}
			}
		}
		max = Math.max(max, cnt);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void calSafe(int sr, int sc) {

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		sink[sr][sc] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || sink[nr][nc])
					continue;
				sink[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}
		}
	}
}
//https://www.acmicpc.net/problem/2468