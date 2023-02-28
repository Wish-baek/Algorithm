import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.naming.LimitExceededException;

public class Gold20058 {
	static int[][] map;
	static boolean[][] visited;
	static int N, size;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		size = (int) Math.pow(2, N);
		map = new int[size][size];
		visited = new boolean[size][size];
		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < size; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < Q; i++) {
			int L = Integer.parseInt(st.nextToken());
			map = split(L);
			map = melt(map);
//			for (int a = 0; a < size; a++) {
//				for (int b = 0; b < size; b++) {
//					System.out.print(map[a][b] + " ");
//				}
//				System.out.println();
//			}
		}
		int sum = 0;
		int max = 0;
		for (int a = 0; a < size; a++) {
			for (int b = 0; b < size; b++) {
				sum += map[a][b];
				if (!visited[a][b] && map[a][b] != 0) {
					max = Math.max(max, bfs(a, b));
				}
			}
		}
		System.out.println(sum);
		System.out.println(max);
	}

	static int[][] split(int l) {
		int[][] tmp = new int[size][size];
		l = (int) Math.pow(2, l);
		for (int i = 0; i < size; i += l) {
			for (int j = 0; j < size; j += l) {
				rotate(i, j, l, tmp);
			}
		}
		return tmp;

	}

	static void rotate(int x, int y, int l, int[][] tmp) {
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < l; j++) {
				tmp[x + i][y + j] = map[x + l - 1 - j][y + i];
			}
		}
	}

	static int[][] melt(int[][] map) {
		int[][] tmp = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int cnt = 0;
				if (map[i][j] == 0)
					continue;
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];

					if (nr < 0 || nr >= size || nc < 0 || nc >= size)
						continue;
					if (tmp[nr][nc] == 0)
						continue;
					cnt++;
				}
				if (cnt < 3)
					map[i][j]--;
			}
		}
		return map;
	}

	static int bfs(int sr, int sc) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int r = tmp[0];
			int c = tmp[1];
			cnt++;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= size || nc < 0 || nc >= size)
					continue;
				if (map[nr][nc] == 0 || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				q.add(new int[] { nr, nc });
			}

		}
		return cnt;
	}

}
//https://www.acmicpc.net/problem/20058