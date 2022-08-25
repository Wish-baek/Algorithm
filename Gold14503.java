import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold14503 {
	static int N, M, cnt;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new boolean[N][M];

		st = new StringTokenizer(br.readLine(), " ");
		int sr = Integer.parseInt(st.nextToken());
		int sc = Integer.parseInt(st.nextToken());
		int sd = Integer.parseInt(st.nextToken());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					visited[i][j] = true;
			}
		}
		cnt++;
		clean(sr, sc, sd);
		System.out.println(cnt);

	}

	static int[] dr = { -1, 0, 1, 0 }; // 북동남서
	static int[] dc = { 0, 1, 0, -1 };

	static void clean(int r, int c, int d) {

		visited[r][c] = true;

		for (int i = 0; i < 4; i++) {
			d = (d + 3) % 4;
			int nr = r + dr[d];
			int nc = c + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && !visited[nr][nc]) {
				cnt++;
				clean(nr, nc, d);
				return;
			}

		}
		int back = (d + 2) % 4;
		int br = r + dr[back];
		int bc = c + dc[back];
		if (br >= 0 && br < N && bc >= 0 && bc < M && map[br][bc] != 1) {
			clean(br, bc, d);
		}
	}
}
//https://www.acmicpc.net/problem/14503