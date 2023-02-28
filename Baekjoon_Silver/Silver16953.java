import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver16953 {
	static long[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		System.out.println(bfs(A, B));
	}

	static long bfs(long start, long end) {
		Queue<long[]> q = new LinkedList<>();
		q.add(new long[] { start, 0 });

		while (!q.isEmpty()) {

			long[] tmp = q.poll();
			long n = tmp[0];
			long cnt = tmp[1];

			if (n == end)
				return cnt + 1;

			if (n * 2 <= end) {
				q.add(new long[] { n * 2, cnt + 1 });
			}
			if (n * 10 + 1 <= end) {
				q.add(new long[] { n * 10 + 1, cnt + 1 });
			}
		}
		return -1;
	}
}
//https://www.acmicpc.net/problem/16953