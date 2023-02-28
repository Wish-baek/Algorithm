import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver17086 {
	static int[][] visited;
	static List<int[]> sList;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 };
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		sList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					sList.add(new int[] { i, j });
			}
		}
		int max = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					continue;
				int n = calDist(i, j);
//				System.out.println(n);
				max = Math.max(max, n);
			}
		}
		System.out.println(max);
	}

	static int calDist(int sr, int sc) {
		visited = new int[N][M];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];
			for (int i = 0; i < 8; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (visited[nr][nc] != 0)
					continue;
				if (map[nr][nc] == 1)
					return visited[r][c];
				q.add(new int[] { nr, nc });
				visited[nr][nc] = visited[r][c] + 1;
			}
		}
		return 0;
	}
}
//https://www.acmicpc.net/problem/17086