import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver6146 {
	static int[][] map;
	static int[][] visited;
	static int X, Y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int X = Integer.parseInt(st.nextToken()) + 500;
		int Y = Integer.parseInt(st.nextToken()) + 500;
		int N = Integer.parseInt(st.nextToken());
		map = new int[1001][1001];
		visited = new int[1001][1001];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken()) + 500;
			int y = Integer.parseInt(st.nextToken()) + 500;
			map[y][x] = -1;

		}
		bfs();

//		for (int i = -3 + 500; i < 510; i++) {
//			for (int j = -3 + 500; j < 510; j++) {
//				System.out.print(map[i][j] + "\t");
//			}
//			System.out.println();
//		}
//		System.out.println();
//		for (int i = -3 + 500; i < 510; i++) {
//			for (int j = -3 + 500; j < 510; j++) {
//				System.out.print(visited[i][j] + "\t");
//			}
//			System.out.println();
//		}
		System.out.println(visited[Y][X] - 1);
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 500, 500 });
		visited[500][500] = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();

			int c = tmp[0];
			int r = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= 1000 || nc < 0 || nc >= 1000)
					continue;
				if (visited[nc][nr] != 0 || map[nc][nr] == -1)
					continue;
				visited[nc][nr] = visited[c][r] + 1;
				q.add(new int[] { nc, nr });

			}
		}
	}
}
//https://www.acmicpc.net/problem/6146