import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold16954 {
	static char[][] map;

	static class wall implements Comparable<wall> {
		int r;
		int c;

		public wall(int r, int c) {
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(wall o) {
			return o.r - this.r;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[8][8];

		String str;
		for (int i = 0; i < 8; i++) {
			str = br.readLine();
			for (int j = 0; j < 8; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		bfs();
		System.out.println(0);

	}

	static int[] dr = { -1, -1, -1, 0, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 0, 1, -1, 0, 1 };

	static void bfs() {
		boolean[][] visited = new boolean[8][8];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 7, 0 });
		visited[7][0] = true;

		while (!q.isEmpty()) {
			int size = q.size();

			for (int s = 0; s < size; s++) {
				int[] tmp = q.poll();
				int r = tmp[0];
				int c = tmp[1];
				visited[r][c] = false;

				if (r == 0 && c == 7) {
					System.out.println(1);
					System.exit(0);
				}

				for (int i = 0; i < 9; i++) {
					int nr = r + dr[i];
					int nc = c + dc[i];
					if (nr < 0 || nr >= 8 || nc < 0 || nc >= 8)
						continue;
					if (map[nr][nc] == '#' || visited[nr][nc])
						continue;
					if (nr > 0 && map[nr - 1][nc] == '#')
						continue;
					q.add(new int[] { nr, nc });
					visited[nr][nc] = true;
				}
			}
			moveWall();
		}
	}

	static void moveWall() {
		for (int i = 7; i >= 0; i--) {
			for (int j = 0; j < 8; j++) {
				if (map[i][j] == '#') {
					if (i == 7)
						map[i][j] = '.';
					else {
						map[i][j] = '.';
						map[i + 1][j] = '#';
					}
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/16954