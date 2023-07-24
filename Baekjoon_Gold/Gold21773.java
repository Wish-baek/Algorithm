import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold21773 {

	static class process implements Comparable<process> {
		int id;
		int time;
		int v;

		public process(int id, int time, int v) {
			this.id = id;
			this.time = time;
			this.v = v;
		}

		@Override
		public int compareTo(process o) {
			if (o.v == this.v) {
				return this.id - o.id;
			}
			return o.v - this.v;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int T = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		PriorityQueue<process> q = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			q.add(new process(A, B, C));
		}

		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= T; t++) {
			if (q.isEmpty())
				break;

			process p = q.poll();
			sb.append(p.id).append("\n");
			if (p.time > 1)
				q.add(new process(p.id, p.time - 1, p.v - 1));
		}

		System.out.println(sb);
	}
}

// https://www.acmicpc.net/problem/21773
