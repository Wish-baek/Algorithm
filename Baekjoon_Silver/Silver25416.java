import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver25416 {
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[5][5];

		StringTokenizer st;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		System.out.println(bfs(r, c));

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs(int start_r, int start_c) {

		boolean[][] visited = new boolean[5][5];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start_r, start_c, 0 });
		visited[start_r][start_c] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];
			int cnt = temp[2];

			if (map[r][c] == 1) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
					continue;
				if (visited[nr][nc] || map[nr][nc] == -1)
					continue;

				q.add(new int[] { nr, nc, cnt + 1 });
				visited[nr][nc] = true;
			}
		}
		return -1;
	}
}

// https://www.acmicpc.net/problem/25416