import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2458 {
	static ArrayList<Integer>[] Graph;
	static ArrayList<Integer>[] Graph2;
	static boolean[][] adj;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Graph = new ArrayList[N + 1];
		Graph2 = new ArrayList[N + 1];
		adj = new boolean[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			Graph[i] = new ArrayList<>();
			Graph2[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph2[b].add(a);
		}
		for (int i = 1; i <= N; i++) {
			connect(i, Graph);
			connect(i, Graph2);
		}

		int result = 0;

		for (int i = 1; i < N + 1; i++) {
			int cnt = 0;
			for (int j = 1; j < N + 1; j++) {
				if (i != j && adj[i][j])
					cnt++;
			}
			if (cnt == N - 1)
				result++;
		}
		System.out.println(result);

	}

	static void connect(int s, ArrayList<Integer>[] Graph) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		visited[s] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < Graph[now].size(); i++) {
				int next = Graph[now].get(i);

				if (!visited[next]) {
					visited[next] = true;
					adj[now][next] = true;
					adj[s][next] = true;
					q.add(next);
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/2458