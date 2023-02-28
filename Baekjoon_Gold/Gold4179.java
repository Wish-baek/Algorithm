import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold4179 {
	static char[][] map;
	static int R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		Queue<int[]> jq = new LinkedList<>();
		Queue<int[]> fq = new LinkedList<>();
		int sr = -1;
		int sc = -1;
		map = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'J') {
					sr = i;
					sc = j;
				} else if (map[i][j] == 'F')
					fq.add(new int[] { i, j });
			}
		}

		System.out.println(bfs(jq, fq, sr, sc));
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static String bfs(Queue<int[]> jq, Queue<int[]> fq, int sr, int sc) {
		boolean[][] visited = new boolean[R][C];
		jq.add(new int[] { sr, sc, 0 });
		visited[sr][sc] = true;
		int size = 0;
		while (!jq.isEmpty()) {

			size = fq.size();
			for (int s = 0; s < size; s++) {
				int[] tmp = fq.poll();
				int r = tmp[0];
				int c = tmp[1];
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						continue;
					if (map[nr][nc] == '#' || map[nr][nc] == 'F')
						continue;
					fq.add(new int[] { nr, nc });
					map[nr][nc] = 'F';
				}
			}
			size = jq.size();
			for (int s = 0; s < size; s++) {
				int[] tmp = jq.poll();
				int r = tmp[0];
				int c = tmp[1];
				int cnt = tmp[2];
				for (int i = 0; i < 4; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];

					if (nr < 0 || nr >= R || nc < 0 || nc >= C)
						return Integer.toString(cnt + 1);
					if (map[nr][nc] != '.' || visited[nr][nc])
						continue;
					visited[nr][nc] = true;
					jq.add(new int[] { nr, nc, cnt + 1 });
				}
			}
		}
		return "IMPOSSIBLE";
	}
}
//https://www.acmicpc.net/problem/4179