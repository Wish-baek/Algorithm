import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1194 {
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		int start_r = -1;
		int start_c = -1;
		int end_r = -1;
		int end_c = -1;

		String str;
		for (int i = 0; i < N; i++) {
			str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '0') {
					start_r = i;
					start_c = j;
				} else if (map[i][j] == '1') {
					end_r = i;
					end_c = j;
				}
			}
		}

		int result = bfs(start_r, start_c, end_r, end_c);
		System.out.println(result);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int bfs(int sr, int sc, int fr, int fc) {
		boolean[][][] visited = new boolean[N][M][1 << 6];

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc, 0, 0 }); // 행, 열, 이동 횟수, 열쇠 상태를 의미하는 비트 값
		visited[sr][sc][0] = true;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];
			int cnt = arr[2];
			int bit = arr[3];

			if (map[r][c] == '1')
				return cnt;

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (map[nr][nc] == '#')
					continue;

				if (97 <= map[nr][nc] && map[nr][nc] <= 102) {
					int newBit = bit | (1 << (map[nr][nc] - 97));
					if (!visited[nr][nc][newBit]) {
						visited[nr][nc][newBit] = true;
						q.add(new int[] { nr, nc, cnt + 1, newBit });
					}
				}

				else if (65 <= map[nr][nc] && map[nr][nc] <= 70) {
					if ((bit & (1 << (map[nr][nc] - 65))) != 0) {
						if (!visited[nr][nc][bit]) {
							visited[nr][nc][bit] = true;
							q.add(new int[] { nr, nc, cnt + 1, bit });
						}
					}
				} else {
					if (!visited[nr][nc][bit]) {
						visited[nr][nc][bit] = true;
						q.add(new int[] { nr, nc, cnt + 1, bit });
					}
				}
			}
		}
		return -1;
	}
}
