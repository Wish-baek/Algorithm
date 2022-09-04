import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16234 {
	static int[][] map;
	static boolean[][] visited;
	static int N, L, R;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int result = 0;

		while (true) {
			visited = new boolean[N][N];
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
						int tmp = bfs(i, j);
						if (tmp == -1)
							continue;
						else
							cnt++;
//						for (int a = 0; a < N; a++) {
//							for (int b = 0; b < N; b++) {
//								System.out.print(map[a][b] + " ");
//							}
//							System.out.println();
//						}
//						System.out.println();
					}

				}

			}
			if (cnt != 0)
				result++;
			else
				break;
		}

		System.out.println(result);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		list.add(new int[] { sr, sc });
		q.add(new int[] { sr, sc });
		int sum = map[sr][sc];

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			visited[sr][sc] = true;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc])
					continue;
				if (L <= Math.abs(map[r][c] - map[nr][nc]) && Math.abs(map[r][c] - map[nr][nc]) <= R) {
					visited[nr][nc] = true;
					q.add(new int[] { nr, nc });
					list.add(new int[] { nr, nc });
					sum += map[nr][nc];
				}

			}
		}
		if (list.size() == 1)
			return -1;
		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			map[r][c] = sum / list.size();
		}
		return list.size();

	}

}
//https://www.acmicpc.net/problem/16234