import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver11724 {
	static List<Integer>[] Graph;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];

		Graph = new ArrayList[N + 1];

		for (int i = 1; i < N + 1; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
			bfs(i);
			cnt++;
			}
		}
		System.out.println(cnt);

	}

	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = true;
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < Graph[tmp].size(); i++) {
				int newNode = Graph[tmp].get(i);
				if (!visited[newNode]) {
					q.add(newNode);
					visited[newNode] = true;
				}
			}
		}

	}

}
