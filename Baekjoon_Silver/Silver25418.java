import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver25418 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		bfs(a, b);
	}

	static void bfs(int start, int end) {
		boolean[] visited = new boolean[1000001];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int now = arr[0];
			int cnt = arr[1];

			if (now == end) {
				System.out.println(cnt);
				return;
			}

			if (now + 1 <= 1000000 && !visited[now + 1]) {
				q.add(new int[] { now + 1, cnt + 1 });
				visited[now + 1] = true;
			}

			if (now * 2 <= 1000000 && !visited[now * 2]) {
				q.add(new int[] { now * 2, cnt + 1 });
				visited[now * 2] = true;
			}
		}
	}
}
//https://www.acmicpc.net/problem/25418
