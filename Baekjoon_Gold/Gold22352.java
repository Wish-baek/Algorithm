import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold22352 {
	static int N, M;
	static int[][] before, after;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		before = new int[N][M];
		after = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				before[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int sr = -1;
		int sc = -1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				after[i][j] = Integer.parseInt(st.nextToken());
				if (before[i][j] != after[i][j] && sr == -1) {
					sr = i;
					sc = j;
				}
			}
		}

		if (sr == -1 && sc == -1) {
			System.out.println("YES");
			return;
		}

		bfs(sr, sc, after[sr][sc]);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (before[i][j] != after[i][j]) {
					System.out.println("NO");
					return;
				}
			}
		}

		System.out.println("YES");
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc, int num) {
		int tmp = before[sr][sc];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		before[sr][sc] = num;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (tmp != before[nr][nc])
					continue;

				q.add(new int[] { nr, nc });
				before[nr][nc] = num;
			}
		}
	}
}
//https://www.acmicpc.net/problem/22352