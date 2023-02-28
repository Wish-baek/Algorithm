import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold7569 {
	static int[][][] map;
	static int[][][] visited;
	static int M, N, H, cnt, result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		visited = new int[N][M][H];
		map = new int[N][M][H];

		int tomato = 0; // 익은 토마토
		int empty = 0; // 토마토가 들어있지 않은 칸

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int k = 0; k < M; k++) {
					map[j][k][i] = Integer.parseInt(st.nextToken());
					if (map[j][k][i] == -1)
						empty++;
					else if (map[j][k][i] == 1)
						tomato++;
				}
			}
		}

		if (tomato + empty == N * M * H) {
			System.out.println(0);
			System.exit(0);
		}

		cnt = 0;

		spread();
		if (cnt + empty == N * M * H)
			System.out.println(result - 1);
		else
			System.out.println(-1);

	}

	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	static void spread() {

		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (map[j][k][i] == 1) {
						q.add(new int[] { j, k, i });
						visited[j][k][i] = 1;
					}
				}
			}
		}
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int z = tmp[2];
			cnt++;
			for (int i = 0; i < 6; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				int nz = z + dz[i];
				if (nx < 0 || nx >= N || ny < 0 || ny >= M || nz < 0 || nz >= H)
					continue;
				if (map[nx][ny][nz] == -1 || map[nx][ny][nz] == 1)
					continue;

				q.add(new int[] { nx, ny, nz });
				map[nx][ny][nz] = 1;

				visited[nx][ny][nz] = visited[x][y][z] + 1;

			}

		}

		result = -1;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					result = Math.max(result, visited[j][k][i]);
				}
			}
		}

	}

}
//https://www.acmicpc.net/problem/7569