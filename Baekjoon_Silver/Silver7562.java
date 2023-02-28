import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver7562 {
	static int[][] map;
	static boolean[][] visited;
	static int fr, fc, l;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			l = Integer.parseInt(br.readLine()); // 체스판의 한 변의 길이

			map = new int[l][l];
			visited = new boolean[l][l];
			st = new StringTokenizer(br.readLine(), " ");
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine(), " ");
			fr = Integer.parseInt(st.nextToken());
			fc = Integer.parseInt(st.nextToken());

			bfs(sr, sc);
			System.out.println(map[fr][fc]);
		}
	}

	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };

	static void bfs(int r, int c) {

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;
		map[r][c] = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 8; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];
				if (nx < 0 || nx >= l || ny < 0 || ny >= l || visited[nx][ny] || map[nx][ny] != 0)
					continue;
				visited[nx][ny] = true;
				map[nx][ny] = map[x][y] + 1;
				q.offer(new int[] { nx, ny });
			}
		}

	}

}
//https://www.acmicpc.net/problem/7562