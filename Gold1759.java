import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gold1759 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[] arr = new char[C];
		char[] output = new char[L];
		boolean[] visited = new boolean[C];

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(arr);
		dfs(0, C, L, arr, visited, output, 0);
		System.out.println(sb);
	}

	static void dfs(int at, int C, int L, char[] arr, boolean[] visited, char[] output, int depth) {

		if (depth == L) {

			for (int i = 1; i < L; i++) {
				if (output[i - 1] - '0' > output[i] - '0')
					return;
			}

			int sum = 0;
			int sum2 = 0;
			for (int i = 0; i < L; i++) {
				if (output[i] == 'a' || output[i] == 'e' || output[i] == 'i' || output[i] == 'o' || output[i] == 'u')
					sum++;
				else
					sum2++;
			}

			if (sum < 1 || sum2 < 2)
				return;

			for (char n : output)
				sb.append(n);
			sb.append("\n");

			return;
		}

		for (int i = at; i < C; i++) {
		//	if (!visited[i]) {
				//visited[i] = true;
				output[depth] = arr[i];
				dfs(i+1,C, L, arr, visited, output, depth + 1);
				//visited[i] = false;
//			}
		}

	}
}
