import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold21610 {
	static int[][] map;
	static boolean[][] cloudMap;
	static int[] dr = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[] dc = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cloudMap = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cloudMap[N - 1][0] = true;
		cloudMap[N - 1][1] = true;
		cloudMap[N - 2][0] = true;
		cloudMap[N - 2][1] = true;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			move(d, s); // 1번
			rainy(); // 2번
			waterCopy();
		}

		int result = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result += map[i][j];
			}
		}
		System.out.println(result);

	}

	static void waterCopy() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!cloudMap[i][j] && map[i][j] >= 2) {
					cloudMap[i][j] = true;
					map[i][j] -= 2;
				} else
					cloudMap[i][j] = false;
			}
		}
	}

	static void rainy() {
		List<int[]> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (cloudMap[i][j]) {
					map[i][j]++;
					list.add(new int[] { i, j });
				}
			}
		}

		for (int i = 0; i < list.size(); i++) {
			int r = list.get(i)[0];
			int c = list.get(i)[1];
			int cnt = 0;
			for (int d = 2; d < 9; d += 2) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] == 0)
					continue;
				cnt++;
			}
			map[r][c] += cnt;
		}
	}

	static void move(int d, int s) {
		boolean[][] tmpCloudMap = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmpCloudMap[i][j] = cloudMap[i][j];
				cloudMap[i][j] = false;
			}
		}

		s %= N;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tmpCloudMap[i][j]) {
					q.add(new int[] { i, j });
				}
			}
		}

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			r += dr[d] * s;
			c += dc[d] * s;
			if (r < 0)
				r += N;
			else if (r >= N)
				r -= N;
			if (c < 0)
				c += N;
			else if (c >= N)
				c -= N;
			cloudMap[r][c] = true;
		}
	}
}
//https://www.acmicpc.net/problem/21610