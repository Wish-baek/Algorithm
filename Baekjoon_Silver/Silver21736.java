import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver21736 {
	static int N, M, result;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];

		int sr = -1;
		int sc = -1;

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'I') {
					sr = i;
					sc = j;
				}
			}
		}

		bfs(sr, sc);
		System.out.println(result == 0 ? "TT" : result);
	}

	static void bfs(int sr, int sc) {
		boolean[][] visited = new boolean[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;

		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int r = temp[0];
			int c = temp[1];

			if (map[r][c] == 'P')
				result++;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visited[nr][nc] || map[nr][nc] == 'X')
					continue;
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
			}
		}
	}
}
//https://www.acmicpc.net/problem/21736