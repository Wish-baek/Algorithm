import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4485 {
	static int[][] map;
	static int[][] visited;
	static int N;

	static class Node implements Comparable<Node> {
		int x;
		int y;
		int weight;

		public Node(int x, int y, int weight) {
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {

			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int tc = 1;
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			map = new int[N][N];
			visited = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			find();
			sb.append("Problem").append(" ").append(tc).append(": ").append(visited[N - 1][N - 1]).append("\n");
			// System.out.println(visited[N - 1][N - 1]);
			tc++;
		}
		System.out.print(sb);

	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static void find() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0, 0));
		visited[0][0] = map[0][0];

		while (!q.isEmpty()) {
			Node node = q.poll();
			int r = node.x;
			int c = node.y;
			int w = node.weight;
			if (visited[r][c] < w)
				continue;
			for (int i = 0; i < 4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				if (nr < 0 || nr >= N || nc < 0 || nc >= N)
					continue;
				if (visited[nr][nc] > visited[r][c] + map[nr][nc]) {
					visited[nr][nc] = visited[r][c] + map[nr][nc];
					q.add(new Node(nr, nc, visited[nr][nc]));
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/4485