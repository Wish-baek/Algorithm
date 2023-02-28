import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold10026 {
	static char[][] map;
	static boolean[][] visited;
	static int N;
	static boolean check, isBlue;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		int cnt = 0;
		int cnt2 = 0;
		check = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R' && !visited[i][j]) {
					bfs(i, j, 'R');
					cnt++;
				} else if (map[i][j] == 'G' && !visited[i][j]) {
					bfs(i, j, 'G');
					cnt++;
				} else if (map[i][j] == 'B' && !visited[i][j]) {
					bfs(i, j, 'B');
					cnt++;
				}
			}
		}
		check = true;
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 'R'&& !visited[i][j]) {
					isBlue = false;
					bfs(i, j, 'B');
					cnt2++;
				} else if (map[i][j] == 'G' && !visited[i][j]) {
					isBlue = false;
					bfs(i, j, 'B');
					cnt2++;
				} else if (map[i][j] == 'B' && !visited[i][j]) {
					isBlue = true;
					bfs(i, j, 'B');
					cnt2++;
				}
			}
		}
		System.out.print(cnt + " " + cnt2);
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int r, int c, char s) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { r, c });
		visited[r][c] = true;

		while (!q.isEmpty()) {
			int tmp[] = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dr[i];
				int ny = y + dc[i];

				if (check == false) {
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] != s)
						continue;
				} else if (check == true && !isBlue) {
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] =='B')
						continue;
				} else if (check == true && isBlue) {
					if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || map[nx][ny] != 'B')
						continue;
				}
				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
			}
		}
	}
}
//https://www.acmicpc.net/problem/10026