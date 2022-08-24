import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold3055 {
	static char[][] map, tmpMap;
	static int[][] visited;
	private static int R, C;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		int sr = -1;
		int sc = -1;
		int fr = -1;
		int fc = -1;

		map = new char[R][C];
		visited = new int[R][C];

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'S') {
					sr = i;
					sc = j;
				} else if (map[i][j] == 'D') {
					fr = i;
					fc = j;
				}
			}
		}

		System.out.println(bfs(sr, sc, fr, fc));
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static String bfs(int sr, int sc, int fr, int fc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {sr, sc});
		visited[sr][sc] = 0;
		

		while (true) {
			if (q.isEmpty())
				break;
			flood();
			
			Queue<int[]> tq = new LinkedList<>();
			while (!q.isEmpty()) {
				int[] tmp = q.poll();
				int r = tmp[0];
				int c = tmp[1];

				for (int i = 0; i < 4; i++) {
					if (r + dr[i] == fr && c + dc[i] == fc)
						return Integer.toString(visited[r][c] + 1);
				}

				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == '*' || map[nr][nc] == 'X')
						continue;
					if (visited[nr][nc] > 0)
						continue;
					//System.out.println("nr: " + nr + " nc: " + nc);

					visited[nr][nc] = visited[r][c] + 1;
					tq.add(new int[] { nr, nc });
				}
			}
			q = tq;
		}
		return "KAKTUS";
	}

	static void flood() {

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '*')
					q.add(new int[] { i, j });
			}
		}
		int size = q.size();
		for (int i = 0; i < size; i++) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int k = 0; k < 4; k++) {
				int nr = r + dr[k];
				int nc = c + dc[k];

				if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == 'X' || map[nr][nc] == 'D'
						|| map[nr][nc] == '*')
					continue;

				map[nr][nc] = '*';

			}

		}
	}

}
//https://www.acmicpc.net/problem/3055