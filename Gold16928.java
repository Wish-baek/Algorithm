import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16928 {
	static int[] count;
	static boolean[] visited;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		visited = new boolean[101];
		arr = new int[101];
		count = new int[101];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a] = b;
		}
		bfs();
//		for(int i = 1; i<100; i++) {
//				System.out.print(arr[i]);
//		}

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		count[1] = 0;
		visited[1] = true;
		while (!q.isEmpty()) {
			int now = q.poll();

			if (now == 100) {
				System.out.println(count[100]);
				return;
			}

			for (int i = 1; i <= 6; i++) {
				int next = now + i;
				if (next > 100)
					continue;
				if (visited[next])
					continue;
				visited[next] = true;

				if (arr[next] != 0) {
					if (!visited[arr[next]]) {
						q.offer(arr[next]);
						visited[arr[next]] = true;
						count[arr[next]] = count[now] + 1;

					}
				} else {

					count[next] = count[now] + 1;
					q.add(next);
				}
			}

		}
	}

}
//https://www.acmicpc.net/problem/16928