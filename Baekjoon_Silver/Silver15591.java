import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver15591 {
	static List<Node>[] list;
	static boolean[] visited;
	static int cnt;

	static class Node {
		int to;
		int usado;

		public Node(int to, int usado) {
			this.to = to;
			this.usado = usado;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int usado = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, usado));
			list[b].add(new Node(a, usado));
		}

		for (int i = 0; i < Q; i++) {
			visited = new boolean[N + 1];
			cnt = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			bfs(k, v);
//			System.out.println(Arrays.toString(visited));
			System.out.println(cnt);
		}

	}

	static void bfs(int k, int v) {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < list[now].size(); i++) {
				int next = list[now].get(i).to;
//				System.out.println(next);
				if (!visited[next] && list[now].get(i).usado >= k) {
					cnt++;
					visited[next] = true;
					q.add(next);
				}

			}
		}
	}
}
//https://www.acmicpc.net/problem/15591