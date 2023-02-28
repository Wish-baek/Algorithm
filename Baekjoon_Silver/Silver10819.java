import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver10819 {
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] output = new int[N];
		boolean[] visited = new boolean[N];
		perm(arr, output, visited, 0, N, N);
		System.out.println(max);
	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {

		if (depth == r) {
			int sum = 0;
			for (int i = 1; i < n; i++) {
				sum += Math.abs(output[i - 1] - output[i]);
			}
//			System.out.println(sum);
			max = Math.max(sum, max);

//			System.out.println(Arrays.toString(output));
//			System.exit(0);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(arr, output, visited, depth + 1, n, r);
				visited[i] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/10819