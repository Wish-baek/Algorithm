import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold12893 {
	static ArrayList<Integer>[] graph;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		System.out.println(grouping());
	}

	static int grouping() {
		int[] visited = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int v = 1; v <= N; v++) {
			if (visited[v] == 0) {
				visited[v] = 1;
				q.add(v);
			}

			while (!q.isEmpty()) {
				int now = q.poll();

				for (int i = 0; i < graph[now].size(); i++) {
					int next = graph[now].get(i);

					if (visited[next] == 0) {
						visited[next] = visited[now] * -1;
						q.add(next);
					} else if (visited[next] == visited[now]) {
						return 0;
					}
				}
			}
		}
		return 1;
	}
}

//https://www.acmicpc.net/problem/12893