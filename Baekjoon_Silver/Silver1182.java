import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver1182 {
	static int[] arr;
	static boolean[] visited;
	static int N, S, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N];
			int[] output = new int[i];
			dfs(output, 0, 0, i);

		}

		System.out.println(result);

	}

	static void dfs(int[] output, int at, int depth, int r) {
//		System.out.println(depth + " " +sum);
		if (depth == r) {
			int sum = 0;
			for (int i = 0; i < r; i++) {
				sum += output[i];
			}
			if (sum == S)
				result++;
			return;
		}

		for (int i = at; i < N; i++) {
			visited[i] = true;
			output[depth] = arr[i];
			dfs(output, i + 1, depth + 1, r);
			visited[i] = false;
		}
	}
}
//https://www.acmicpc.net/problem/1182
