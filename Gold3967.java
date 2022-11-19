import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Gold3967 {
	static char[][] map;
	static List<int[]> xList;
	static boolean[] visited;
	static int xCnt;
	static List<String> list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[5][9];
		visited = new boolean[12];
		xList = new ArrayList<>();

		xCnt = 0;
		list = new ArrayList<>();
		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == '.')
					continue;
				if (65 <= map[i][j] && map[i][j] <= 76) {
					visited[map[i][j] - 65] = true;
				}

				if (map[i][j] == 'x')
					xList.add(new int[] { i, j });
			}
		}

		dfs(0);
	}

	static void dfs(int depth) {
		if (depth == xList.size()) {

			if (isPossible()) {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(map[i][j]);
					}
					System.out.println();
				}
				System.exit(0);
			}
			return;
		}

		for (int k = 0; k < 12; k++) {
			if (!visited[k]) {
				int[] now = xList.get(depth);
				map[now[0]][now[1]] = (char) (k + 65);
				visited[k] = true;
				dfs(depth + 1);
				visited[k] = false;
				map[now[0]][now[1]] = '.';
			}
		}
	}

	static boolean isPossible() {
		int sum1 = map[0][4] - 64 + map[1][3] - 64 + map[2][2] - 64 + map[3][1] - 64;
		int sum2 = map[0][4] - 64 + map[1][5] - 64 + map[2][6] - 64 + map[3][7] - 64;
		int sum3 = map[1][1] - 64 + map[1][3] - 64 + map[1][5] - 64 + map[1][7] - 64;
		int sum4 = map[3][1] - 64 + map[3][3] - 64 + map[3][5] - 64 + map[3][7] - 64;
		int sum5 = map[4][4] - 64 + map[3][3] - 64 + map[2][2] - 64 + map[1][1] - 64;
		int sum6 = map[4][4] - 64 + map[3][5] - 64 + map[2][6] - 64 + map[1][7] - 64;
		if (sum1 == 26 && sum2 == 26 && sum3 == 26 && sum4 == 26 && sum5 == 26 && sum6 == 26)
			return true;
		else
			return false;
	}
}
//https://www.acmicpc.net/problem/3967