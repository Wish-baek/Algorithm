import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold1987 {
	static int max, R, C, cnt;
	static char[][] arr;
	static boolean[][] visited;
	static List<Character> list;
	static boolean[] alpha;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new char[R][C];
		visited = new boolean[R][C];
		list = new ArrayList<>();
		alpha = new boolean[26];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		max = -1;
		dfs(0, 0, 0);

		System.out.println(max);
	}

	private static int[] dr = { -1, 1, 0, 0 }; // 상하좌우
	private static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int r, int c, int cnt) {
		max = Math.max(max, cnt);
		if (r < 0 || r >= R || c < 0 || c >= C || visited[r][c])
			return;
		if (alpha[arr[r][c] - 65])
			return;
		for (int i = 0; i < dr.length; i++) {
			alpha[arr[r][c] - 65] = true;
			dfs(r + dr[i], c + dc[i], cnt + 1);
			alpha[arr[r][c] - 65] = false;
		}
	}
}
//https://www.acmicpc.net/problem/1987