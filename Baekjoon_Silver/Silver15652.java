import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver15652 {
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] output = new int[M];
		for (int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}

		perm(0, arr, output, 0, N, M);
		System.out.println(sb);
	}

	static void perm(int at, int[] a, int[] out, int depth, int n, int m) {
		if (depth == m) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = at; i < n; i++) {
			
				out[depth] = a[i];
				perm(i, a, out, depth + 1, n, m);
			
		}

	}

}
//https://www.acmicpc.net/problem/15652