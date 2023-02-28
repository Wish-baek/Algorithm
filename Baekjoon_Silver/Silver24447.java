import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver24447 {
	static long[] depth;
	static long[] visited;
	static List<Integer>[] Graph;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		Graph = new ArrayList[N + 1];

		depth = new long[N + 1];
		visited = new long[N + 1];

		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
			depth[i] = -1;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(Graph[i]);

		}
		cnt = 1;
		bfs(R);
		long sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += depth[i] * visited[i];
		}

//		for (int i = 1; i <= N; i++) {
//			System.out.println(depth[i] + " " + visited[i]);
//		}
		System.out.println(sum);

	}

	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		depth[start] = 0;
		visited[start] = cnt;
		while (!q.isEmpty()) {
			int tmp = q.poll();

			for (int i = 0; i < Graph[tmp].size(); i++) {
				int newNode = Graph[tmp].get(i);
				if (depth[newNode] == -1 && visited[newNode] == 0) {
					cnt++;
					depth[newNode] = depth[tmp] + 1;
					visited[newNode] = cnt;
					q.add(newNode);
				}
			}

		}

	}

}
//https://www.acmicpc.net/problem/24447