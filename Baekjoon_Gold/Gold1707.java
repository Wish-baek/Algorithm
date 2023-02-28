import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1707 {
	static List<Integer>[] Graph;
	static int[] color;
	static int V, E;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < K; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			Graph = new ArrayList[V + 1];
			color = new int[V + 1];

			for (int i = 1; i <= V; i++)
				Graph[i] = new ArrayList<>();

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				Graph[a].add(b);
				Graph[b].add(a);
			}
			bfs();
		}
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();

		for (int j = 1; j <= V; j++) {

			if (color[j] == 0) {
				q.add(j);
				color[j] = 1;
			}

			while (!q.isEmpty()) {
				int now = q.poll();

				for (int i = 0; i < Graph[now].size(); i++) {
					int next = Graph[now].get(i);
					if (color[next] == color[now]) {
						System.out.println("NO");
						return;
					}

					else if (color[next] == 0) {
						q.add(next);
						color[next] = color[now] * -1;
					}
				}
			}
		}
		System.out.println("YES");
	}
}
//https://www.acmicpc.net/problem/1707