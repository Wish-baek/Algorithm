import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver13565 {
	static int[][] map;
	static boolean[][] visited;
	static int M, N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[M][N];

		for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		visited = new boolean[M][N];

		for (int i = 0; i < N; i++) {

			if (!visited[0][i] && map[0][i] == 0) {
				visited[0][i] = true;
				bfs(0, i);
			}

		}

		for (int i = 0; i < N; i++) {
			if (visited[M - 1][i] == true && map[M - 1][i] == 0) {
				System.out.println("YES");
				System.exit(0);
			}
		}

//		for(int i = 0; i<M;i++) {
//			for(int j = 0; j<N;j++) {
//				System.out.print(visited[i][j] + " ");
//			}System.out.println();
//		}
		System.out.println("NO");

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= M || nc < 0 || nc >= N)
					continue;
				if (map[nr][nc] == 1 || visited[nr][nc])
					continue;

				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });

			}
		}
	}

}
//https://www.acmicpc.net/problem/13565