import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver9205 {
	static class point {
		int r;
		int c;
		int idx;

		public point(int r, int c, int idx) {
			this.r = r;
			this.c = c;
			this.idx = idx;
		}
	}

	static point[] list;
	static int[] visited;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {

			n = Integer.parseInt(br.readLine());

			list = new point[n + 2];
			visited = new int[n + 2];

			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[0] = new point(r, c, 0);
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				r = Integer.parseInt(st.nextToken());
				c = Integer.parseInt(st.nextToken());
				list[i] = new point(r, c, i);
			}
			st = new StringTokenizer(br.readLine(), " ");
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list[n + 1] = new point(r, c, n + 1);

			point s = list[0];
			point f = list[n + 1];
			System.out.println(bfs(s, f));

		}
	}

	static String bfs(point s, point f) {
		Queue<point> q = new LinkedList<>();
		q.add(s);
		visited[0] = 1;

		while (!q.isEmpty()) {
			point now = q.poll();
			int r = now.r;
			int c = now.c;
			int idx = now.idx;

			if (r == f.r && c == f.c)
				return "happy";

			for (int i = 1; i < n + 2; i++) {
				point next = list[i];
				int nr = next.r;
				int nc = next.c;
				int nidx = next.idx;
				if (visited[nidx] != 0)
					continue;
				if (Math.abs(nr - r) + Math.abs(nc - c) > 1000)
					continue;

				q.add(next);
				visited[nidx] = visited[idx] + 1;
			}

		}
		return "sad";
	}
}