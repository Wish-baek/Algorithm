import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold3109 {
	static char[][] arr;
	static int cnt, r, c;
	static boolean[][] visited;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		r = Integer.parseInt(st.nextToken());
		c= Integer.parseInt(st.nextToken());

		arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			String str =br.readLine();
			for (int j = 0; j < c; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		visited = new boolean[r][c];
		int count = 0;
		for (int i = 0; i < r; i++) {
			if (dfs(i, 0))
				count++;
		}
		System.out.println(count);
	}

	

	public static boolean dfs(int x, int y) {
		for (int i = 0; i < 3; i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];

			if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
				if (visited[nx][ny] == false && arr[nx][ny] == '.') {
					visited[nx][ny] = true;
					if (ny == c - 1)
						return true;
					if (dfs(nx, ny))
						return true;
				}
			}
		}
		return false;
	}

}
//https://www.acmicpc.net/problem/3109