import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold17070 {
	static int[][] map;
	static int N, cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0, 1, 0);
		System.out.println(cnt);
	}

	static int[] dr = { 0, 1, 1 }; // 우, 하, 우하
	static int[] dc = { 1, 0, 1 };

	static void dfs(int r, int c, int d) {
		if (r < 0 || r >= N || c < 0 || c >= N || map[r][c] == 1)
			return;

		if (d == 2) {
//			System.out.println(r + " " +c);
			if ((r - 1 >= 0 && c - 1 >= 0) && map[r - 1][c] == 1 || map[r][c - 1] == 1)
				return;
		}
		if (r == N - 1 && c == N - 1) {
			cnt++;
			return;
		}

		if (d == 0) { // 우
			dfs(r + dr[0], c + dc[0], 0);
			dfs(r + dr[2], c + dc[2], 2);
		} else if (d == 1) { // 하
			dfs(r + dr[1], c + dc[1], 1);
			dfs(r + dr[2], c + dc[2], 2);
		} else if (d == 2) { // 우하
			dfs(r + dr[0], c + dc[0], 0);
			dfs(r + dr[1], c + dc[1], 1);
			dfs(r + dr[2], c + dc[2], 2);
		}
	}
}
//https://www.acmicpc.net/problem/17070