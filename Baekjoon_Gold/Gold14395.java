import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold14395 {
	static boolean[] visited;
	static String[] str;
	static List<Long> list;

	static class Node {
		long now;
		String oper;

		public Node(long now, String oper) {
			this.now = now;
			this.oper = oper;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		long s = Long.parseLong(st.nextToken());
		long t = Long.parseLong(st.nextToken());

		if (s == t) {
			System.out.println(0);
			System.exit(0);
		}

		list = new ArrayList<>();

		if (s > t) {
			bfs(s, t);
		} else {
			bfs(s, t);
		}

	}

	static void bfs(long s, long t) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(s, ""));
		while (!q.isEmpty()) {
			Node node = q.poll();
			long now = node.now;
			String oper = node.oper;

			if (now == t) {
				System.out.println(oper);
				return;
			}

			if (now * now <= 1000000000 && !list.contains(now * now)) {
				q.add(new Node(now * now, oper + "*"));
				list.add(now * now);
			}
			if (now + now <= 1000000000 && !list.contains(now + now)) {
				q.add(new Node(now + now, oper + "+"));
				list.add(now + now);
			}
			if (now - now >= 1 && !list.contains(now - now)) {
				q.add(new Node(now - now, oper + "-"));
				list.add(now - now);
			}

			if (now != 0 && now / now >= 1 && !list.contains(now / now)) {
				q.add(new Node(now / now, oper + "/"));
				list.add(now / now);
			}
		}
		System.out.println(-1);

	}

}
//https://www.acmicpc.net/problem/14395