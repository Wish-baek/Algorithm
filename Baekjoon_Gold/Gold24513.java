import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold24513 {
	static int N, M;
	static char[][] map;
	static boolean[][] visited;
	static Queue<int[]> q; // 늑대 위치

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M];

		q = new LinkedList<>();

		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'W') {
					q.add(new int[] { i, j });
					visited[i][j] = true;
				}
			}
		}

		bfs();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '.' && !visited[i][j])
					System.out.print("P");
				else
					System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs() {
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == '#' || visited[nr][nc])
					continue;

				if (map[nr][nc] == '+') { // 빙판이라면

					while (true) {
						nr += dr[i];
						nc += dc[i];

						if (map[nr][nc] == '.' || map[nr][nc] == 'W')
							break;
						else if (map[nr][nc] == '#') {
							nr -= dr[i];
							nc -= dc[i];
							break;
						}
					}
				}

				if (visited[nr][nc])
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}

// https://www.acmicpc.net/problem/16441