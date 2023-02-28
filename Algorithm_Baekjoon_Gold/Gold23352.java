import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold23352 {
	static int[][] map;
	static int[][] visited;
	static int N, M, max;
	static int pw;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					continue;

				int[] tmp = bfs(i, j);
				if (tmp[0] > max) {
					max = tmp[0];
					pw = tmp[1];
				} else if (tmp[0] == max && tmp[1] > pw) {
					max = tmp[0];
					pw = tmp[1];
				}
			}
		}

		System.out.println(pw);

	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static int[] bfs(int sr, int sc) {
		visited = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visited[nr][nc] != 0 || map[nr][nc] == 0)
					continue;

				visited[nr][nc] = visited[r][c] + 1;
				q.add(new int[] { nr, nc });
			}
		}
		int[] tmp = new int[2];
		tmp[0] = -1;
		tmp[1] = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (visited[i][j] > tmp[0]) {

					tmp[0] = visited[i][j];
					tmp[1] = map[sr][sc] + map[i][j];
				}
			}
		}

		return tmp;

	}

}
//https://www.acmicpc.net/problem/23352