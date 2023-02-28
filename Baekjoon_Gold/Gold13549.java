import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold13549 {
	static int N, K;
	static int[] dist;
	static Queue<Integer> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dist = new int[100001];
		bfs();
		System.out.println(dist[K] - 1);
	}

	static void bfs() {
		q.offer(N);
		dist[N] = 1;
		while (!q.isEmpty()) {
			int now = q.poll();

			int cnt = dist[now];
			if (now == K)
				break;

			if (now * 2 <= 100000 && now * 2 >= 0 && (dist[now * 2] == 0 || dist[now * 2] == dist[now])) {

				q.offer(now * 2);
				dist[now * 2] = cnt;
			}

			if (now - 1 <= 100000 && now - 1 >= 0 && (dist[now - 1] == 0 || dist[now - 1] == dist[now] + 1)) {

				q.offer(now - 1);
				dist[now - 1] = cnt + 1;
			}
			if (now + 1 <= 100000 && now + 1 >= 0 && (dist[now + 1] == 0 || dist[now + 1] == dist[now] + 1)) {

				q.offer(now + 1);
				dist[now + 1] = cnt + 1;
			}

		}
	}
}
//https://www.acmicpc.net/problem/13549