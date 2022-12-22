import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver11060 {
	static int[] arr;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[N];
		bfs();
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		visited[0] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int time = tmp[1];

			if (now == N - 1) {
				System.out.println(time);
				return;
			}

			for (int i = 1; i <= arr[now]; i++) {
				if (now + i < N && !visited[now + i]) {
					q.add(new int[] { now + i, time + 1 });
					visited[now + i] = true;
				}
			}
		}
		System.out.println(-1);
	}
}
//https://www.acmicpc.net/problem/11060