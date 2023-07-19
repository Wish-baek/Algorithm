import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Silver14235 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		StringTokenizer st;

		PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
			return o2 - o1;
		});

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			if (a == 0) {
				if (q.isEmpty())
					sb.append("-1").append("\n");
				else
					sb.append(q.poll()).append("\n");
			} else {
				for (int j = 0; j < a; j++) {
					q.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		System.out.println(sb);
	}
}

//https://www.acmicpc.net/problem/14235