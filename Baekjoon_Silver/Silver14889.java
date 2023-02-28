import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver14889 {
	static boolean[] visited;
	static int[][] map;
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N];
		min = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		comb(0, 0);
		System.out.println(min);

	}

	static void comb(int depth, int at) {
		if (depth == N / 2) {
			int start = 0;
			int link = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (visited[i] && visited[j])
						start += map[i][j];
					else if (!visited[i] && !visited[j])
						link += map[i][j];
				}
			}
			min = Math.min(min, Math.abs(start - link));
		}

		for (int i = at; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				comb(depth + 1, i + 1);
				visited[i] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/14889