import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold1941 {
	static char[][] map;
	static boolean[] visited, vis;
	static int[] output;
	static int res;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][5];

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 5; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		visited = new boolean[25];
		output = new int[7];
		combi(0, output, 0, 0, 0);
		System.out.println(res);

	}

	static void combi(int at, int[] output, int depth, int s, int y) {
		if (depth == 7) {

			if (s >= 4) {
				if (bfs(output[0], output[0] / 5, output[0] % 5)) {
					res++;
				}
				return;
			}
			return;
		}

		for (int i = at; i < 25; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = i;
				if (map[i / 5][i % 5] == 'S') {
					combi(i + 1, output, depth + 1, s + 1, y);
				} else if (map[i / 5][i % 5] == 'Y') {
					combi(i + 1, output, depth + 1, s, y + 1);
				}
				visited[i] = false;
			}

		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[] dn = { -5, 5, -1, 1 };

	static boolean bfs(int sn, int sr, int sc) {
		vis = new boolean[25];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sn, sr, sc });
		vis[sn] = true;
		int cnt = 1;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int n = tmp[0];
			int r = tmp[1];
			int c = tmp[2];

			for (int i = 0; i < 4; i++) {
				int nn = n + dn[i];
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
					continue;
				if (vis[nn])
					continue;
				if (!visited[nn])
					continue;
				cnt++;
				vis[nn] = true;
				q.add(new int[] { nn, nr, nc });
			}
		}
		if (cnt == 7)
			return true;
		else
			return false;
	}

}
//https://www.acmicpc.net/problem/1941