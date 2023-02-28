import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16236 {
	static int[][] map, visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N, size, eat;

	static class Fish implements Comparable<Fish> {
		int r;
		int c;
		int dist;

		public Fish(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}

		@Override
		public int compareTo(Fish o) {
			if (this.dist == o.dist) {
				if (this.c == o.c) {
					return this.c - o.c;
				}
				return this.r - o.r;
			}
			return this.dist - o.dist;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];

		int r = -1;
		int c = -1;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 9) {
					r = i;
					c = j;
				}
			}
		}
		map[r][c] = 0;
		size = 2;
		int time = 0;
		while (true) {
			Fish fish = findFish(r, c);
			map[r][c] = 0;
			eat++;
			if (fish == null)
				break;
			if (eat == size) {
				size++;
				eat = 0;
			}
			time += fish.dist - 1;
			r = fish.r;
			c = fish.c;
			map[r][c] = 0;

		}
		System.out.println(time);

	}

	static Fish findFish(int sr, int sc) {
		visited = new int[N][N];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc });
		visited[sr][sc] = 1;
		while (!q.isEmpty()) {
			int[] now = q.poll();
			int r = now[0];
			int c = now[1];

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];

				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] != 0 || map[nr][nc] > size)
					continue;

				q.add(new int[] { nr, nc });
				visited[nr][nc] = visited[r][c] + 1;
			}
		}
		PriorityQueue<Fish> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] != 0 && map[i][j] < size && visited[i][j] != 0) {
					pq.add(new Fish(i, j, visited[i][j]));
				}
			}
		}

		return pq.poll();

	}

	static boolean endCheck() {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] < size)
					cnt++;
			}
		}

		if (cnt == 0)
			return true;
		else
			return false;
	}

}
//https://www.acmicpc.net/problem/16236