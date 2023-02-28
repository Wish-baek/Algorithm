import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3187 {
	static char[][] map;
	static boolean[][] visited;
	static int R, C, sheep, wolf, s, w;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (!visited[i][j] && map[i][j] != '.' && map[i][j] != '#') {
					bfs(i, j);
					if (s > w) {
						sheep += s;
					} else
						wolf += w;
				}
			}
		}
		System.out.println(sheep + " " + wolf);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc) {
		s = 0;
		w = 0;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			if (map[r][c] == 'v')
				w++;
			else if (map[r][c] == 'k')
				s++;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (visited[nr][nc] || map[nr][nc] == '#')
					continue;

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });

			}
		}
//		System.out.println(sr + " " + sc + " " + s + " " + w);
	}

}
//https://www.acmicpc.net/problem/3187