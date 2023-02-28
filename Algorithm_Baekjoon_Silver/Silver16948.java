import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver16948 {
	static int[][] map;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int fr = Integer.parseInt(st.nextToken());
		int fc = Integer.parseInt(st.nextToken());

		bfs(sr, sc, fr, fc);
		if (map[fr][fc] == 0)
			System.out.println(-1);
		else
			System.out.println(map[fr][fc] - 1);

	}

	static int[] dr = { -2, -2, 0, 0, 2, 2 };
	static int[] dc = { -1, 1, -2, 2, -1, 1 };

	static void bfs(int sr, int sc, int fr, int fc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		map[sr][sc] = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 6; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (map[nr][nc] != 0)
					continue;
				q.add(new int[] { nr, nc });
				map[nr][nc] = map[r][c] + 1;
			}
		}
	}

}
//https://www.acmicpc.net/problem/16948