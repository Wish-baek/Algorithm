import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2146 {
	static int[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int num = 1;
		for (int i = 0; i < N; i++) { // 섬 분리 표시
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					bfs(i, j, num);
					num++;
				}

			}
		}
//		for (int i = 0; i < N; i++) { // 섬 분리 표시
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
		min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0)
					findMinDist(i, j, map[i][j]);
			}
		}

		System.out.println(min - 2);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc, int num) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		map[sr][sc] = num;
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] || map[nr][nc] == 0)
					continue;
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
				map[nr][nc] = num;
			}
		}
	}

	static void findMinDist(int sr, int sc, int num) {
		dist = new int[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		dist[sr][sc] = 1;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (dist[nr][nc] != 0 || map[nr][nc] == num)
					continue;

				q.add(new int[] { nr, nc });
				dist[nr][nc] = dist[r][c] + 1;
			}
		}

		int tmp = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && map[i][j] != num && dist[i][j] != 0)
					tmp = Math.min(tmp, dist[i][j]);
			}
		}
//		System.out.println();
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(dist[i][j] + " ");
//			}System.out.println();
//		}

		min = Math.min(min, tmp);
	}

}
//https://www.acmicpc.net/problem/2146