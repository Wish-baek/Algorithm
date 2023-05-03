import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1326 {
	static int[] arr;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		bfs(a, b);
		System.out.println(-1);

	}

	static void bfs(int start, int end) {
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int cnt = tmp[1];

			if (now == end) {
				System.out.println(cnt);
				System.exit(0);
			}

			for (int i = N; i >= 1; i--) {
				int move = arr[now - 1] * i;
				if (now - move >= 1 && !visited[now - move]) {
					q.add(new int[] { now - move, cnt + 1 });
					visited[now - move] = true;
				}
				if (now + move <= N && !visited[now + move]) {
					q.add(new int[] { now + move, cnt + 1 });
					visited[now + move] = true;
				}
			}

		}
	}
}
//https://www.acmicpc.net/problem/1326