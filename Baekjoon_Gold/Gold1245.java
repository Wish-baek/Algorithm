import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1245 {
	static ArrayList<int[]> topList;
	static boolean[][] visited;
	static int[][] map;
	static int N, M;
	static boolean isTop;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		topList = new ArrayList<int[]>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int result = 0;
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visited[i][j] && map[i][j] != 0) {
					isTop = true;
					bfs(i, j);
					if (isTop) {
						result++;
					}
				}
			}
		}
		System.out.println(result);
	}

	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] > map[r][c]) {
					isTop = false;
				}
				if (visited[nr][nc])
					continue;

				if (map[nr][nc] == map[r][c]) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/1245