import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold14217 {
	static StringBuilder sb;
	static ArrayList<Integer>[] Graph;
	static boolean[] visited;
	static int[] result;
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[n + 1];
		result = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}

		int q = Integer.parseInt(br.readLine());

		for (int k = 0; k < q; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());

			if (a == 1) {
				Graph[i].add(j);
				Graph[j].add(i);
			}

			else if (a == 2) {
				for (int l = 0; l < Graph[i].size(); l++) {
					if (Graph[i].get(l) == j) {
						Graph[i].remove(l);
						break;
					}
				}

				for (int l = 0; l < Graph[j].size(); l++) {
					if (Graph[j].get(l) == i) {
						Graph[j].remove(l);
						break;
					}
				}
			}
			bfs();
		}
		System.out.println(sb);
	}

	static void bfs() {
		result = new int[n + 1];

		Arrays.fill(result, -1);

		visited = new boolean[n + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 0 });
		visited[1] = true;
		result[1] = 0;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int now = arr[0];
			int dist = arr[1];

			for (int i = 0; i < Graph[now].size(); i++) {
				int next = Graph[now].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(new int[] { next, dist + 1 });
					result[next] = dist + 1;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			sb.append(result[i]).append(" ");
		}
		sb.append("\n");
	}
}
//https://www.acmicpc.net/problem/14217