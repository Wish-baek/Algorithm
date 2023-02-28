import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver1697 {
	static int[] visited;
	static int K;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new int[100001];
		System.out.println(bfs(N));
	}

	static int bfs(int n) {
		Queue<Integer> q = new LinkedList<>();

		q.add(n);
		int here = 0;
		visited[n] = 1;
		while (!q.isEmpty()) {

			here = q.poll();
			if (here == K)
				return visited[here] - 1;

			if (here - 1 >= 0 && visited[here - 1] == 0) {
				visited[here - 1] = visited[here] + 1;
				q.add(here - 1);
			}
			if (here + 1 <= 100000 && visited[here + 1] == 0) {
				visited[here + 1] = visited[here] + 1;
				q.add(here + 1);
			}
			if (2 * here <= 100000 && visited[2 * here] == 0) {
				visited[here * 2] = visited[here] + 1;
				q.add(here * 2);
			}

		}

		return -1;
	}

}
//https://www.acmicpc.net/problem/1697