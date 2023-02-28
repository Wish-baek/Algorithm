import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold6593 {
	static char[][][] map;
	static int[][][] visited;
	static int L, R, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			L = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			if (L == 0 && R == 0 && C == 0)
				break;

			map = new char[R][C][L];
			visited = new int[R][C][L];

			int sx = -1;
			int sy = -1;
			int sz = -1;
			int fx = -1;
			int fy = -1;
			int fz = -1;

			for (int i = 0; i < L; i++) {
				for (int j = 0; j < R; j++) {
					String str = br.readLine();
					for (int k = 0; k < C; k++) {
						map[j][k][i] = str.charAt(k);
						if (map[j][k][i] == 'S') {
							sx = j;
							sy = k;
							sz = i;
						} else if (map[j][k][i] == 'E') {
							fx = j;
							fy = k;
							fz = i;
						}
					}
				}
				br.readLine();
			}
			escape(sx, sy, sz);

			if (visited[fx][fy][fz] == 0)
				System.out.println("Trapped!");
			else
				System.out.println("Escaped in " + visited[fx][fy][fz] + " minute(s).");

		}

	}

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	static void escape(int sx, int sy, int sz) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sx, sy, sz });
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int z = tmp[2];

			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];

				if (nx < 0 || nx >= R || ny < 0 || ny >= C || nz < 0 || nz >= L)
					continue;
				if (map[nx][ny][nz] == '#' || visited[nx][ny][nz] != 0)
					continue;
				q.add(new int[] { nx, ny, nz });
				visited[nx][ny][nz] = visited[x][y][z] + 1;
			}

		}
	}

}
//https://www.acmicpc.net/problem/6593