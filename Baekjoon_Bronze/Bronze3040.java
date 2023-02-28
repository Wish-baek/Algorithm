import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze3040 {
	static int cnt;
	static int[] numbers, arr, output;

	static void dfs(int at, int[] arr, int[] output, int depth, int n, int r) {
		if (depth == r) {
			int sum = 0;
			for (int i = 0; i < output.length; i++) {
				sum += output[i];
			}
			if (sum == 100) {
				for (int i = 0; i < output.length; i++) {
					System.out.println(output[i]);
				}
				return;
			}
			return;
		} else {
			for (int i = at; i < 9; i++) {
				output[depth] = arr[i];
				dfs(i + 1, arr, output, depth + 1, n, r);
			}
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		numbers = new int[9];
		arr = new int[9];
		output = new int[7];
		for (int i = 0; i < 9; i++) {
			numbers[i] = Integer.parseInt(br.readLine());
		}
		dfs(0, numbers, output, 0, 9, 7);

	}

}
//https://www.acmicpc.net/problem/3040