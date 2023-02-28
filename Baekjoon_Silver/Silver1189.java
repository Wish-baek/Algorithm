import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1189 {

	static char[][] map;
	static boolean[][] visited;
	static int R, C, K, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new char[R][C];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited[R - 1][0] = true;
		dfs(R - 1, 0, 0);
		System.out.println(result);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int dist) {

		if (r == 0 && c == C - 1 && dist + 1 == K) {
			result++;
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= R || nc < 0 || nc >= C)
				continue;
			if (visited[nr][nc] || map[nr][nc] == 'T')
				continue;
			if (!visited[nr][nc]) {
				visited[nr][nc] = true;
				dfs(nr, nc, dist + 1);
				visited[nr][nc] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/1189