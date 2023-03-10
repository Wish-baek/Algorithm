import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver11123 {
	static char[][] map;
	static boolean[][] visited;
	static int H, W;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			int result = 0;

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (!visited[i][j] && map[i][j] != '.') {
						bfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= H || nc < 0 || nc >= W)
					continue;
				if (visited[nr][nc] || map[nr][nc] == '.')
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}
//https://www.acmicpc.net/problem/11123