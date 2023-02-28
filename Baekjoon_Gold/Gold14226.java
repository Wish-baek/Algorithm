import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Gold14226 {
	static boolean[][] visited;
	static int S;

	static class emoticon {
		int display;
		int clipboard;
		int time;

		public emoticon(int d, int c, int t) {
			this.display = d;
			this.clipboard = c;
			this.time = t;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		visited = new boolean[1001][1001];
		System.out.println(bfs());

	}

	static int bfs() {
		int res = 0;
		Queue<emoticon> q = new LinkedList<>();
		q.add(new emoticon(1, 0, 0));
		visited[1][0] = true;

		while (!q.isEmpty()) {
			emoticon em = q.poll();
			int dis = em.display;
			int clip = em.clipboard;
			int time = em.time;

			if (dis == S) {
				res = time;
				break;
			}
			if (!visited[dis][dis]) {
				q.add(new emoticon(dis, dis, time + 1));
				visited[dis][dis] = true;
			}

			if (clip != 0 && !visited[dis + clip][clip]) {
				q.add(new emoticon(dis + clip, clip, time + 1));
				visited[dis + clip][clip] = true;
			}

			if (dis != 0 && !visited[dis - 1][clip]) {
				q.add(new emoticon(dis - 1, clip, time + 1));
				visited[dis - 1][clip] = true;
			}
		}
		return res;
	}
}
//https://www.acmicpc.net/problem/14226