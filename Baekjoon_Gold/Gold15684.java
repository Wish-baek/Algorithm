import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold15684 {
	static int[][] map;
	static boolean[] visited;
	static int N, M, H;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		map = new int[H][N];
		visited = new boolean[H * N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[a][b] = 2;
			map[a][b + 1] = 1;
		}

		int[] tmp = {};
		if (isPossible(tmp)) {
			System.out.println(0);
			System.exit(0);
		}

		for (int i = 1; i <= 3; i++) {
			int[] output = new int[i];
			dfs(0, 0, i, output);
		}

		System.out.println(-1);

	}

	static void dfs(int at, int depth, int c, int[] output) {

		if (depth == c) {
			if (isPossible(output)) {
				System.out.println(c);
				System.exit(0);
			}
			return;
		}

		for (int i = at; i < H * N; i++) {
			if (visited[i])
				continue;
			if (i % N == N - 1)
				continue;
			if (map[i / N][i % N] != 0 || map[i / N][i % N+1] != 0)
				continue;
			
			visited[i] = true;
			output[depth] = i;
			dfs(i + 1, depth + 1, c, output);
			visited[i] = false;

		}
	}

	static boolean isPossible(int[] output) {
		int[][] tmp = new int[H][N];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < output.length; i++) {
			int r = output[i] / N;
			int c = output[i] % N;
			tmp[r][c] = 2;
			tmp[r][c + 1] = 1;
		}

		for (int i = 0; i < N; i++) {
			int r = 0;
			int c = i;

			while (r <= H - 1) {
				if (tmp[r][c] == 1)
					c--;
				else if (tmp[r][c] == 2)
					c++;
				r++;
			}
			if (c != i)
				return false;

		}

		return true;
	}
}
//https://www.acmicpc.net/problem/15684