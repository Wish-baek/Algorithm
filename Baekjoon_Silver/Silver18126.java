import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver18126 {
	static int N;
	static long max;
	static ArrayList<info>[] Graph;

	static class info {
		int to;
		long weight;

		public info(int to, long weight) {
			this.to = to;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Graph = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			long C = Integer.parseInt(st.nextToken());
			Graph[A].add(new info(B, C));
			Graph[B].add(new info(A, C));
		}

		bfs();
		System.out.println(max);

	}

	static void bfs() {
		boolean[] visited = new boolean[N + 1];
		Queue<info> q = new LinkedList<>();
		q.add(new info(1, 0));
		visited[1] = true;

		while (!q.isEmpty()) {
			info tmp = q.poll();
			int now = tmp.to;
			long sum = tmp.weight;

			max = Math.max(max, sum);

			for (int i = 0; i < Graph[now].size(); i++) {
				info info = Graph[now].get(i);
				int next = info.to;
				long w = info.weight;

				if (!visited[next]) {
					visited[next] = true;
					q.add(new info(next, sum + w));

				}

			}
		}
	}
}
//https://www.acmicpc.net/problem/18126