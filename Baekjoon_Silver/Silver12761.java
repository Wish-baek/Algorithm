import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver12761 {
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new int[100001];
		bfs(N, M, A, B);
		System.out.println(visited[M] - 1);
	}

	static void bfs(int n, int m, int A, int B) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		visited[n] = 1;
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now + 1 < 100001 && visited[now + 1] == 0) {
				q.add(now + 1);
				visited[now + 1] = visited[now] + 1;
			}
			if (now - 1 >= 0 && visited[now - 1] == 0) {
				q.add(now - 1);
				visited[now - 1] = visited[now] + 1;
			}
			if (now * A < 100001 && visited[now * A] == 0) {
				q.add(now * A);
				visited[now * A] = visited[now] + 1;
			}
			if (now * B < 100001 && visited[now * B] == 0) {
				q.add(now * B);
				visited[now * B] = visited[now] + 1;
			}

			if (now + A < 100001 && visited[now + A] == 0) {
				q.add(now + A);
				visited[now + A] = visited[now] + 1;
			}
			if (now + B < 100001 && visited[now + B] == 0) {
				q.add(now + B);
				visited[now + B] = visited[now] + 1;
			}
			if (now - A >= 0 && visited[now - A] == 0) {
				q.add(now - A);
				visited[now - A] = visited[now] + 1;
			}
			if (now - B >= 0 && visited[now - B] == 0) {
				q.add(now - B);
				visited[now - B] = visited[now] + 1;
			}
		}
	}
}
//https://www.acmicpc.net/problem/12761