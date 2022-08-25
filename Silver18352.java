import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver18352 {
	static List<Integer>[] Graph;
	static int[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[N + 1];
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			visited[i] = -1;
		}
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
		}
		bfs(X);
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (visited[i] == K)
				result.add(i);
		}
		if (result.size() == 0)
			System.out.println(-1);
		else {
			Collections.sort(result);
			for (int i = 0; i < result.size(); i++) {
				System.out.println(result.get(i));
			}
		}
	}

	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();

		q.add(x);
		visited[x] = 0;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int i = 0; i < Graph[node].size(); i++) {
				int newNode = Graph[node].get(i);
				if (visited[newNode] == -1) {
					visited[newNode] = visited[node] + 1;
					q.add(newNode);
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/18352