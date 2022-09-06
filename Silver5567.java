import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver5567 {
	static List<Integer>[] Graph;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		Graph = new ArrayList[n + 1];
		visited = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}
		bfs();
		int cnt = 0;
		for (int i = 0; i < n + 1; i++) {
			if (visited[i] <= 3 && visited[i] != 0)
				cnt++;
		}
		System.out.println(cnt - 1);

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = 1;
		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < Graph[now].size(); i++) {
				int next = Graph[now].get(i);
				if (visited[next] == 0) {
					visited[next] = visited[now] + 1;
					q.add(next);
				}
			}

		}
	}

}
//https://www.acmicpc.net/problem/5567