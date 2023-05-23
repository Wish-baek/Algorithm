import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver16173 {
	static int N;
	static String result;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		result = "Hing";
		bfs();

		System.out.println(result);
	}

	static void bfs() {
		boolean[][] visited = new boolean[N][N];
		Queue<int[]> q = new LinkedList();
		visited[0][0] = true;
		q.add(new int[] { 0, 0 });

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int r = arr[0];
			int c = arr[1];

			if (r == N - 1 && c == N - 1) {
				result = "HaruHaru";
				return;
			}

			int num = map[r][c];

			if (r + num < N && !visited[r + num][c]) {
				visited[r + num][c] = true;
				q.add(new int[] { r + num, c });
			}
			if (c + num < N && !visited[r][c + num]) {
				visited[r][c + num] = true;
				q.add(new int[] { r, c + num });
			}

		}

	}
}
