import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16562 {
	static int N, result;
	static int[] arr;
	static boolean[] visited;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		arr = new int[N + 1];

		graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) { // 그룹 별로 최솟값 찾기
			if (!visited[i])
				result += bfs(i);
		}

		System.out.println(result <= k ? result : "Oh no");

	}

	static int bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		visited[node] = true;
		q.add(node);
		int min = arr[node];

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);

				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					min = Math.min(min, arr[next]); // 최솟값 갱신
				}
			}
		}
		return min;
	}
}
// https://www.acmicpc.net/problem/16562