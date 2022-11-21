import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold1405 {
	static double[] ratio;
	static int[][] map;
	static boolean[][] visited;
	static int n;
	static double result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());

		ratio = new double[4];

		for (int i = 0; i < 4; i++) {
			ratio[i] = Double.parseDouble(st.nextToken()) / 100;
		}

		map = new int[31][31];
		visited = new boolean[31][31];
		visited[15][15] = true;
		dfs(0, 15, 15, 1);
		System.out.println(result);

	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { 1, -1, 0, 0 };

	static void dfs(int depth, int r, int c, double total) {

		if (depth == n) {
			result += total;
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (ratio[i] > 0) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (!visited[nr][nc]) {
					visited[nr][nc] = true;
					dfs(depth + 1, nr, nc, total * ratio[i]);
					visited[nr][nc] = false;
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/1405