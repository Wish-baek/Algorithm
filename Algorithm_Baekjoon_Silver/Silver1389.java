import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1389 {

	static List<Integer>[] Graph;
	static int[] visited;
	static int N, min, min_num;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}

		min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			int tmp = bfs(i);
			if (tmp < min) {
				min = tmp;
				min_num = i;
			}
		}

		System.out.println(min_num);

	}

	static int bfs(int s) {
		visited = new int[N + 1];
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		while (!q.isEmpty()) {
			int node = q.poll();

			for (int i = 0; i < Graph[node].size(); i++) {
				int newNode = Graph[node].get(i);
				if (visited[newNode] == 0 && newNode != s) {
					visited[newNode] = visited[node] + 1;
					q.add(newNode);
				}
			}
		}
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			if (i == s)
				continue;
			sum += visited[i];
		}
		return sum;
	}

}
//https://www.acmicpc.net/problem/1389