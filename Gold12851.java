import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold12851 {

	static int[] dist;
	static int K, tmp, cnt, minDist;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		minDist = Integer.MAX_VALUE;
		dist = new int[100001];
		cnt = 0;
		bfs(N);
		if (N >= K) {
			System.out.println((N - K) + "\n1");
			return;
		}

		System.out.println(dist[K] - 1);
		System.out.println(cnt);
	}

	static void bfs(int n) {

		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		dist[n] = 1;
		while (!q.isEmpty()) {
			tmp = q.poll();

			if (minDist < dist[tmp])
				return;

			if (tmp + 1 == K || tmp - 1 == K || tmp * 2 == K) {
				minDist = dist[tmp];
				cnt++;
			}

			if (tmp + 1 <= 100000 && (dist[tmp + 1] == 0 || dist[tmp + 1] == dist[tmp] + 1)) {
				dist[tmp + 1] = dist[tmp] + 1;
				q.offer(tmp + 1);
			}
			if (tmp - 1 >= 0 && (dist[tmp - 1] == 0 || dist[tmp - 1] == dist[tmp] + 1)) {
				dist[tmp - 1] = dist[tmp] + 1;
				q.offer(tmp - 1);
			}
			if (tmp * 2 <= 100000 && (dist[tmp * 2] == 0 || dist[tmp * 2] == dist[tmp] + 1)) {
				dist[tmp * 2] = dist[tmp] + 1;
				q.offer(tmp * 2);
			}
		}
	}
}
//https://www.acmicpc.net/problem/12851