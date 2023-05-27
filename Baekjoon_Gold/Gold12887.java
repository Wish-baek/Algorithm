import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold12887 {
	
	static char[][] map;
	static int N, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[2][N];

		int white = 0;

		String str;
		for (int i = 0; i < 2; i++) {
			str = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '.')
					white++;
			}
		}

		min = Integer.MAX_VALUE;
		if (map[0][0] == '.')
			bfs(0);
		if (map[1][0] == '.')
			bfs(1);

		System.out.println(white - min);
	}

	static int[] dr = { -1, 1, 0 };
	static int[] dc = { 0, 0, 1 };

	static void bfs(int start) {
		boolean[][] visited = new boolean[2][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start, 0, 1 });
		visited[start][0] = true;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			int cnt = arr[2];

			if (c == N - 1) {
				min = Math.min(min, cnt);
				return;
			}

			for (int i = 0; i < 3; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= 2 || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] || map[nr][nc] == '#')
					continue;

				q.add(new int[] { nr, nc, cnt + 1 });
				visited[nr][nc] = true;
			}
		}
	}
}
//https://www.acmicpc.net/problem/12887