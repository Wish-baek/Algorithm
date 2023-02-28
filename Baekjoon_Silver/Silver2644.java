import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver2644 {
	static List<ArrayList<Integer>> Node;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());

		int m = Integer.parseInt(br.readLine());

		Node = new ArrayList<>();
		visited = new boolean[n + 1];
		for (int i = 0; i <= n; i++) {
			Node.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Node.get(a).add(b);
			Node.get(b).add(a);
		}
		bfs(s, f);

	}

	static void bfs(int s, int f) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { s, 0 });
		visited[s] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int cnt = tmp[1];

			if (now == f) {
				System.out.println(cnt);
				return;
			}

			for (int i = 0; i < Node.get(now).size(); i++) {
				int newNode = Node.get(now).get(i);
				if (!visited[newNode]) {
					visited[newNode] = true;
					q.add(new int[] { newNode, cnt + 1 });
					
				}
			}
		}
		System.out.println(-1);
	}
}
//https://www.acmicpc.net/problem/2644