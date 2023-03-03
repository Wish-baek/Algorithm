import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold16947 {
	static boolean[] isCycle;
	static ArrayList<Integer>[] Graph;
	static int[] result;
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Graph = new ArrayList[N + 1];
		isCycle = new boolean[N + 1];
		result = new int[N + 1];

		for (int i = 1; i <= N; i++)
			Graph[i] = new ArrayList();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			if (findCycle(i, i, i))
				break;
			isCycle = new boolean[N + 1];
		}

		for (int i = 1; i <= N; i++) {
			if (isCycle[i])
				continue;
			result[i] = bfs(i);
		}

		for (int i = 1; i <= N; i++)
			System.out.print(result[i] + " ");
	}

	static boolean findCycle(int now, int before, int start) {
		isCycle[now] = true;

		for (int i = 0; i < Graph[now].size(); i++) {
			int next = Graph[now].get(i);

			if (!isCycle[next]) {
				if (findCycle(next, now, start))
					return true;
			} else if (next != before && next == start)
				return true;
		}
		isCycle[now] = false;
		return false;
	}

	static int bfs(int start) {
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> q = new LinkedList();
		q.add(new int[] { start, 0 });
		visited[start] = true;

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int w = tmp[1];

			if (isCycle[now])
				return w;

			for (int i = 0; i < Graph[now].size(); i++) {
				int next = Graph[now].get(i);
				if (!visited[next]) {
					visited[next] = true;
					q.add(new int[] { next, w + 1 });
				}
			}
		}

		return 0;
	}
}
//https://www.acmicpc.net/problem/16947