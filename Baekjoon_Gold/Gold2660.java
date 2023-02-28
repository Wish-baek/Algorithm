import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold2660 {
	static int[] score;
	static List<Integer>[] Graph;
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		Graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if (a == -1 && b == -1)
				break;

			Graph[a].add(b);
			Graph[b].add(a);
		}

		score = new int[N + 1];
		min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		StringBuilder sb = new StringBuilder();
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			if (score[i] == min) {
				cnt++;
				sb.append(i).append(" ");
			}
		}
		System.out.println(min + " " + cnt);
		System.out.println(sb);
	}

	static void bfs(int n) {
		int max = -1;
		boolean[] visited = new boolean[N + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { n, 0 });
		visited[n] = true;
		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int now = tmp[0];
			int dis = tmp[1];
			for (int i = 0; i < Graph[now].size(); i++) {
				int next = Graph[now].get(i);
				if (!visited[next]) {
					q.add(new int[] { next, dis + 1 });
					visited[next] = true;
					max = Math.max(max, dis + 1);
				}
			}
		}
		score[n] = max;
		min = Math.min(min, max);
	}
}
//https://www.acmicpc.net/problem/2660