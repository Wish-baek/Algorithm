import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold18428 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[][] map;
	static List<teacher> tList;
	static int N, student;

	static class teacher {
		int r, c;

		teacher(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		tList = new ArrayList<>();
		student = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if (map[i][j] == 'S')
					student++;
				else if (map[i][j] == 'T')
					tList.add(new teacher(i, j));
			}
		}

		dfs(0);
		System.out.println("NO");

	}

	static void dfs(int depth) {

		if (depth == 3) {
			if (isPossible()) {
				System.out.println("YES");
				System.exit(0);
			}
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'X') {
					map[i][j] = 'O';
					dfs(depth + 1);
					map[i][j] = 'X';
				}
			}
		}
	}

	static boolean isPossible() {
		int cnt = 0;
		boolean[][] visited = new boolean[N][N];
		for (int i = 0; i < tList.size(); i++) {
			int r = tList.get(i).r;
			int c = tList.get(i).c;

			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				while (true) {
					if (nr < 0 || nr >= N || nc < 0 || nc >= N)
						break;
					else if (map[nr][nc] == 'O')
						break;
					else if (map[nr][nc] == 'S' && !visited[nr][nc]) {
						cnt++;
						visited[nr][nc] = true;
					}
					nr += dr[d];
					nc += dc[d];
				}
			}
		}
		if (cnt == 0)
			return true;
		else
			return false;
	}
}
//https://www.acmicpc.net/problem/18428