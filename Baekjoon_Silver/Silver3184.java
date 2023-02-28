import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver3184 {
	static char[][] map;
	static boolean[][] visited;
	static int R, C, sheep, wolf;

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
				if (!visited[i][j] && map[i][j] != '#') {
					visited[i][j] = true;
					bfs(i, j);

				}
			}
		}

		System.out.println(sheep + " " + wolf);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		int s = 0;
		int w = 0;
		if (map[sr][sc] == 'o')
			s++;
		else if (map[sr][sc] == 'v')
			w++;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= R || nc < 0 || nc >= C)
					continue;
				if (visited[nr][nc] || map[nr][nc] == '#')
					continue;

				if (map[nr][nc] == 'o')
					s++;
				else if (map[nr][nc] == 'v')
					w++;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
		if (s > w)
			sheep += s;
		else
			wolf += w;
	}

}
//https://www.acmicpc.net/problem/3184