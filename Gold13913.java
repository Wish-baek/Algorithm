import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold13913 {
	static int[] visited;
	static int[] path;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			System.out.println(0);
			System.out.println(N);
			System.exit(0);
		}

		visited = new int[100001];
		path = new int[100001];
		bfs(N, K);
		Stack<Integer> stack = new Stack<>();
		int n = K;
		while (true) {
			stack.add(path[n]);
			n = path[n];
			if (n == N)
				break;
		}

		System.out.println(visited[K]);
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println(K);
	}

	static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == end) {
				return;
			}

			if (now + 1 <= 100000 && visited[now + 1] == 0) {
				visited[now + 1] = visited[now] + 1;
				path[now + 1] = now;
				q.add(now + 1);
			}

			if (now - 1 >= 0 && visited[now - 1] == 0) {
				visited[now - 1] = visited[now] + 1;
				path[now - 1] = now;
				q.add(now - 1);
			}

			if (now * 2 <= 100000 && visited[now * 2] == 0) {
				visited[now * 2] = visited[now] + 1;
				path[now * 2] = now;
				q.add(now * 2);
			}
		}
	}
}
//https://www.acmicpc.net/problem/13913