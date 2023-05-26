import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16509 {
	static int[][] dr = { { -1, -1, -1 }, { -1, -1, -1 }, { 0, -1, -1 }, { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 },
			{ 0, 1, 1 }, { 0, -1, -1 } };
	static int[][] dc = { { 0, -1, -1 }, { 0, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 }, { 0, 1, 1 }, { 0, -1, -1 },
			{ -1, -1, -1 }, { -1, -1, -1 } };

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sangR = Integer.parseInt(st.nextToken());
		int sangC = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		int kingR = Integer.parseInt(st.nextToken());
		int kingC = Integer.parseInt(st.nextToken());

		result = -1;

		bfs(sangR, sangC, kingR, kingC);
		System.out.println(result);

	}

	static void bfs(int sangR, int sangC, int kingR, int kingC) {
		boolean[][] visited = new boolean[10][9];
		Queue<Object[]> q = new LinkedList<>();
		q.add(new Object[] { sangR, sangC, 0, "" });
		visited[sangR][sangC] = true;

		while (!q.isEmpty()) {
			Object[] arr = q.poll();
			int r = (int) arr[0];
			int c = (int) arr[1];
			int cnt = (int) arr[2];

			if (r == kingR && c == kingC) {
				result = cnt;
				return;
			}

			for (int i = 0; i < 8; i++) {
				boolean isPossible = true;
				int nr = r;
				int nc = c;

				for (int j = 0; j < 3; j++) {
					nr += dr[i][j];
					nc += dc[i][j];

					if (nr < 0 || nr >= 10 || nc < 0 || nc >= 9) {
						isPossible = false;
						break;
					}

					if (j != 2 && nr == kingR && nc == kingC) {
						isPossible = false;
						break;
					}

				}

				if (isPossible) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.add(new Object[] { nr, nc, cnt + 1, (String) ((String) arr[3] + i) });
					}
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/16509
