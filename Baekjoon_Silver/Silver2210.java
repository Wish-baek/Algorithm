import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Silver2210 {
	static String[][] map;
	static Set<String> set;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[5][5];
		for (int i = 0; i < 5; i++) {
			String[] tmp = br.readLine().split(" ");
			for (int j = 0; j < 5; j++) {
				map[i][j] = tmp[j];
			}
		}
		set = new HashSet<>();
		String str = "";
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				dfs(1, i, j, str);
			}
		}

		System.out.println(set.size());

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void dfs(int cnt, int r, int c, String str) {
		if (cnt == 7) {
			set.add(str);
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= 5 || nc < 0 || nc >= 5)
				continue;
			dfs(cnt + 1, nr, nc, str + map[nr][nc]);
		}

	}

}
//https://www.acmicpc.net/problem/2210