import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2589 {
	static char[][] map;
	static int[][] visited;
	static int max, N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}

		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					max = Math.max(max, bfs(i, j));
				}

			}
		}
		System.out.println(max - 1);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs(int sr, int sc) {
		visited = new int[N][M];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = 1;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc] != 0 || map[nr][nc] == 'W')
					continue;
				visited[nr][nc] = visited[r][c] + 1;
				q.add(new int[] { nr, nc });
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(visited[i][j] + " ");
//			}
//			System.out.println();
//		}
		return calMaxDist(visited);

	}

	static int calMaxDist(int[][] visited) {
		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L')
					max = Math.max(max, visited[i][j]);
			}
		}
		return max;
	}

}
//https://www.acmicpc.net/problem/2589