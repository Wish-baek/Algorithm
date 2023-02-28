import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver15654 {
	static StringBuilder sb;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] output = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);

		perm(arr, output, 0, N, M);
		System.out.println(sb);
	}

	static void perm(int[] a, int[] out, int depth, int n, int m) {
		if (depth == m) {
			for (int i = 0; i < out.length; i++) {
				sb.append(out[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
			
				out[depth] = a[i];
				perm(a, out, depth + 1, n, m);
				visited[i] = false;
			}
		}

	}

}
//https://www.acmicpc.net/problem/15654