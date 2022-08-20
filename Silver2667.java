import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Silver2667 {
	static int[][] map;
	static int[][] visited;
	static int N;
	static int cnt;
	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int r = -1;
		int c = -1;
		map = new int[N][N];
		visited = new int[N][N];
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			String[] str = br.readLine().split("");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
			}
		}

		cnt = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					bfs(i, j);
					cnt++;
				}
			}
		}

//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(visited[i][j]);
//			}
//			System.out.println();
//		}
		System.out.println(cnt - 1);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { r, c });
		visited[r][c] = cnt;
		int count = 1;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			for (int i = 0; i < 4; i++) {

				int nx = x + dr[i];
				int ny = y + dc[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] != 0 || map[nx][ny] == 0)
					continue;
				visited[nx][ny] = cnt;
				count++;
				q.offer(new int[] { nx, ny });
			}
		}
		list.add(count);
	}
}
//https://www.acmicpc.net/problem/2667