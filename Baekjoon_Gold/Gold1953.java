import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1953 {
	static ArrayList<Integer>[] graph;
	static int n;
	static String blue, white;
	static int blue_cnt, white_cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		StringTokenizer st;

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int total = Integer.parseInt(st.nextToken());
			for (int j = 0; j < total; j++) {
				int a = Integer.parseInt(st.nextToken());
				graph[i + 1].add(a);
			}
		}

		blue = "";
		white = "";

		bfs();

		System.out.println(blue_cnt);
		System.out.println(blue);
		System.out.println(white_cnt);
		System.out.println(white);
	}

	static void bfs() {
		int[] visited = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();

		for (int v = 1; v <= n; v++) {
			if (visited[v] == 0) {
				visited[v] = 1;
				blue_cnt++;
				q.add(v);
			}

			while (!q.isEmpty()) {
				int now = q.poll();

				for (int i = 0; i < graph[now].size(); i++) {
					int next = graph[now].get(i);

					if (visited[next] == 0) {
						visited[next] = visited[now] * -1;
						if (visited[next] == 1)
							blue_cnt++;
						else if (visited[next] == -1)
							white_cnt++;
						q.add(next);
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (visited[i] == 1)
				blue += Integer.toString(i) + " ";
			else if (visited[i] == -1)
				white += Integer.toString(i) + " ";
		}
	}
}
//https://www.acmicpc.net/problem/1953