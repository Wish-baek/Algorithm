import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold5427 {
	static char[][] map;
	static boolean[][] visited;
	static int w, h, time;
	static Queue<int[]> q, fq;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			map = new char[h][w];
			visited = new boolean[h][w];

			q = new LinkedList<>();
			fq = new LinkedList<>();
			for (int i = 0; i < h; i++) {
				String str = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '@') {
						q.add(new int[] { i, j, 0 });
						visited[i][j] = true;
					}
					if (map[i][j] == '*')
						fq.add(new int[] { i, j });

				}
			}

			System.out.println(spread());
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static String spread() {
		int size = 0;
		while (!q.isEmpty()) {
			size = fq.size();

			for (int s = 0; s < size; s++) {
				int[] tmp = fq.poll();
				int r = tmp[0];
				int c = tmp[1];

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= h || nc < 0 || nc >= w)
						continue;
					if (map[nr][nc] == '#' || map[nr][nc] == '*')
						continue;

					map[nr][nc] = '*';
					fq.add(new int[] { nr, nc });

				}
			}

			size = q.size();
			for (int s = 0; s < size; s++) {
				int[] tmp = q.poll();
				int r = tmp[0];
				int c = tmp[1];
				int cnt = tmp[2];
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= h || nc < 0 || nc >= w)
						return Integer.toString(cnt + 1);

					if (map[nr][nc] != '.' || visited[nr][nc])
						continue;
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc, cnt + 1 });
				}
			}

		}
		return "IMPOSSIBLE";
	}
}
//https://www.acmicpc.net/problem/5427