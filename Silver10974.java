import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver10974 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		for (int i = 1; i <= n; i++) {
			arr[i - 1] = i;
		}

		boolean[] visited = new boolean[n];
		int[] output = new int[n];
		perm(arr, output, visited, 0, n);
	}

	static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n) {

		if (depth == n) {
			for (int i = 0; i < n; i++) {
				System.out.print(output[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = i + 1;
				perm(arr, output, visited, depth + 1, n);
				visited[i] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/10974