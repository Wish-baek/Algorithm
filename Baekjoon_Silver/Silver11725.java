import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver11725 {
	static List<Integer>[] Graph;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Graph = new ArrayList[N + 1];
		visited = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}

		bfs();
		for (int i = 2; i < N + 1; i++) {
			System.out.println(visited[i]);
		}

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1]=1;

		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < Graph[tmp].size(); i++) {
				int newNode = Graph[tmp].get(i);
				if (visited[newNode] == 0) {
					visited[newNode] = tmp;
					q.add(newNode);
				}

			}
		}
	}

}
