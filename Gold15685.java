import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold15685 {
	static int[][] map;
	static int[] dr = { 0, -1, 0, 1 };
	static int[] dc = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[101][101];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int c = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
			drawing(r, c, d, g);
		}
		int result = 0;

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] == 1 && map[i + 1][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j + 1] == 1)
					result++;
			}
		}
		System.out.println(result);

	}

	static void drawing(int r, int c, int d, int g) {
		List<Integer> list = new ArrayList<>();
		list.add(d);
		for (int i = 0; i < g; i++) {
			int size = list.size();
			for (int j = size - 1; j >= 0; j--) {
				list.add((list.get(j) + 1) % 4);
			}
		}
		map[r][c] = 1;
		int nr = r;
		int nc = c;
		for (int i = 0; i < list.size(); i++) {
			nr = nr + dr[list.get(i)];
			nc = nc + dc[list.get(i)];
			map[nr][nc] = 1;
		}
	}
}
//https://www.acmicpc.net/problem/15685