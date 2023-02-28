import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold17471 {
	static List<Integer>[] Graph;
	static int[] arr;
	static boolean[] visited;
	static int N, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		Graph = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int to = Integer.parseInt(st.nextToken());
				Graph[i].add(to);
				Graph[to].add(i);
			}
		}

		min = Integer.MAX_VALUE;

		for (int i = 1; i <= N - 1; i++) {
			visited = new boolean[N + 1];
			int[] output = new int[i];
			int[] output2 = new int[N - i];
			combi(output, output2, 1, 0, i);
		}
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	static void combi(int[] output, int[] output2, int at, int depth, int r) {
		if (depth == r) {
			int idx = 0;
			for (int i = 1; i <= N; i++) {
				if (!visited[i])
					output2[idx++] = i;
			}

			if (isPossible(output, output2, r)) {
//				System.out.println(Arrays.toString(output));
//				System.out.println(Arrays.toString(output2));
				int sum1 = 0;
				for (int i = 0; i < r; i++) {
					sum1 += arr[output[i]];
				}

				int sum2 = 0;
				for (int i = 0; i < N - r; i++) {
					sum2 += arr[output2[i]];
				}
				min = Math.min(min, Math.abs(sum1 - sum2));
			}

			return;
		}

		for (int i = at; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = i;
				combi(output, output2, i + 1, depth + 1, r);
				visited[i] = false;
			}
		}
	}

	static boolean isPossible(int[] output, int[] output2, int r) {
//		System.out.println(Arrays.toString(output));
//		System.out.println(Arrays.toString(output2));

		boolean[] visit = new boolean[N + 1];
		for(int i = 0; i<N-r; i++) {
			visit[output2[i]] =true;
		}
		Queue<Integer> q = new LinkedList<>();
		q.add(output[0]);
		visit[output[0]] = true;

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int i = 0; i < Graph[node].size(); i++) {
				int newNode = Graph[node].get(i);
				if (!visit[newNode]) {
					visit[newNode] = true;
					q.add(newNode);
				}
			}
		}

		for (int i = 0; i < r; i++) {
			if (!visit[output[i]])
				return false;
		}

//		System.out.println("len: " + visit.length);
//		System.out.println(output2[0]);

		q = new LinkedList<>();
		visit = new boolean[N + 1];
		for(int i = 0; i<r; i++) {
			visit[output[i]] =true;
		}
		q.add(output2[0]);
		visit[output2[0]] = true;

		while (!q.isEmpty()) {
			int node = q.poll();

			for (int i = 0; i < Graph[node].size(); i++) {
				int newNode = Graph[node].get(i);
				if (!visit[newNode]) {
					visit[newNode] = true;
					q.add(newNode);
				}
			}
		}

		for (int i = 0; i < N - r; i++) {
			if (!visit[output2[i]])
				return false;
		}

		return true;
	}

}
//https://www.acmicpc.net/problem/17471