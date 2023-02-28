import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold1261 {
	static char[][] map;
	static boolean[][] visited;
	static int N, M;

	static class Node implements Comparable<Node> {
		int r;
		int c;
		int cnt;

		public Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Node o) {
			return this.cnt - o.cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		System.out.println(breakWall());
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static int breakWall() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, 0));
		visited[0][0] = true;
		while (!q.isEmpty()) {
			Node node = q.poll();
			int r = node.r;
			int c = node.c;
			int cnt = node.cnt;

			if (r == N - 1 && c == M - 1) {
				return cnt;
			}

			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
					continue;
				visited[nr][nc] = true;
				if (map[nr][nc] == '1')
					q.add(new Node(nr, nc, cnt + 1));
				else if (map[nr][nc] == '0')
					q.add(new Node(nr, nc, cnt));
			}
		}
		return 0;
	}
}
//https://www.acmicpc.net/problem/1261