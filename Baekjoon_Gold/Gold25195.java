import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold25195 {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] isFan;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}

		int S = Integer.parseInt(br.readLine());
		isFan = new boolean[N + 1];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < S; i++) {
			int a = Integer.parseInt(st.nextToken());
			isFan[a] = true;
		}

		boolean result = bfs();
		System.out.println(result ? "Yes" : "yes");
	}

	static boolean bfs() {
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, isFan[1] ? 1 : 0 });
		while (!q.isEmpty()) {
			int[] arr = q.poll();
			int now = arr[0];
			int cnt = arr[1];

			if (graph[now].size() == 0) {
				if (cnt == 0)
					return false;
			}

			for (int i = 0; i < graph[now].size(); i++) {
				int next = graph[now].get(i);
				q.add(new int[] { next, isFan[next] ? cnt + 1 : cnt });
			}
		}
		return true;
	}
}
//https://www.acmicpc.net/problem/25195