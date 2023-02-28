import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold1043 {
	static List<Integer>[] Graph;
	static boolean[] isknow;
	static List<int[]> party;
	static int[] knowSecret;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());
		knowSecret = new int[K];
		for (int i = 0; i < K; i++) {
			knowSecret[i] = Integer.parseInt(st.nextToken());
		}
		party = new ArrayList<>();
		Graph = new ArrayList[N + 1];
		isknow = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < n - 1; j++) {
				Graph[arr[j]].add(arr[j + 1]);
				Graph[arr[j + 1]].add(arr[j]);
			}
			party.add(arr);
		}
		for (int i = 0; i < K; i++) {
			int n = knowSecret[i];
			bfs(n);
		}

		int cnt = 0;
		for (int i = 0; i < M; i++) {
			boolean ck = true;
			for (int j = 0; j < party.get(i).length; j++) {
				int n = party.get(i)[j];
				if (isknow[n]) {
					ck = false;
					break;
				}
			}
			if (ck == true)
				cnt++;
		}
		System.out.println(cnt);
	}

	static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		q.add(s);
		isknow[s] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < Graph[now].size(); i++) {
				int next = Graph[now].get(i);
				if (isknow[next])
					continue;
				isknow[next] = true;
				q.add(next);
			}
		}
	}
}
//https://www.acmicpc.net/problem/1043