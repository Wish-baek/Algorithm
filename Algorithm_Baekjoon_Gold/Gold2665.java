import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold2665 {
	static int n, min;
	static int[][] map, visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		min = Integer.MAX_VALUE;
		bfs();
		System.out.println(visited[n - 1][n - 1]);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		visited = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				visited[i][j] = Integer.MAX_VALUE;
			}
		}
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visited[0][0] = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;

				if (map[nr][nc] == 0 && visited[r][c] + 1 <= visited[nr][nc]) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = Math.min(visited[nr][nc], visited[r][c] + 1);
				} else if (map[nr][nc] == 1 && visited[r][c] + 1 <= visited[nr][nc]) {
					q.add(new int[] { nr, nc });
					visited[nr][nc] = visited[r][c];
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/2665