import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold19640 {
	static class person implements Comparable<person> {
		int D;
		int H;
		int N;
		int L;

		public person(int D, int H, int N, int L) {
			this.D = D;
			this.H = H;
			this.N = N;
			this.L = L;
		}

		@Override
		public int compareTo(person o) {
			if (o.D == this.D) {
				if (o.H == this.H)
					return this.L - o.L;
				return o.H - this.H;
			}
			return o.D - this.D;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		PriorityQueue<person> q = new PriorityQueue<>();

		person[] list = new person[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int D = Integer.parseInt(st.nextToken());
			int H = Integer.parseInt(st.nextToken());
			list[i] = new person(D, H, i + 1, -1);
		}

		int idx = 0;

		int len = N < M ? N : M;

		for (idx = 0; idx < len; idx++) {

			list[idx].L = idx;
			q.add(list[idx]);
		}

		int cnt = 0;

		while (true) {
			person go = q.poll();

			if (go.N == K + 1)
				break;

			cnt++;

			if (go.N + M <= N) {
				list[go.N - 1 + M].L = go.L;
				q.add(list[go.N - 1 + M]);
			}
		}

		System.out.println(cnt);
	}
}

// https://www.acmicpc.net/problem/19640 