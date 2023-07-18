import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Silver23757 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			q.add(n);
		}

		boolean isPossible = true;

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {

			int gift = q.poll();
			int child = Integer.parseInt(st.nextToken());

			if (child > gift) {
				isPossible = false;
				break;
			}

			q.add(gift - child < 0 ? 0 : gift - child);
		}

		System.out.println(isPossible ? 1 : 0);
	}
}

// https://www.acmicpc.net/problem/23757