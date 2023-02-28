import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1325 {
	static List<Integer>[] Graph;
	static boolean[] visited;
	static int[] result;
	static int max, max_num, N, M;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
//			Graph[b].add(a);
		}

		max = -1;

		for(int i=1; i<N+1; i++) {
			bfs(i);
		}

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, result[i]);
		}

		for (int i = 1; i <= N; i++) {
			if (max == result[i]) {
				System.out.print(i + " ");
			}
		}

	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		visited = new boolean[N + 1];
		q.add(s);
		visited[s] = true;
		while (!q.isEmpty()) {
			int node = q.poll();
			for (int newNode : Graph[node]) {
				if (!visited[newNode]) {
					visited[newNode] = true;
					q.add(newNode);
					result[newNode]++;
				}
			}
		}

	}

}
