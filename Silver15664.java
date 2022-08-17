import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver15664 {
	static int N, M;
	static int[] arr;
	static int[] output;
	static Set<String> set;
	static boolean[] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		set = new HashSet<>();
		arr = new int[N];
		output = new int[M];
		visited = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		perm(0, output, 0, M);

		System.out.println(sb);

	}

	static void perm(int at, int[] output, int depth, int r) {

		if (depth == r) {
			StringBuilder sb2 = new StringBuilder();
			for(int i = 0; i < M; i++) {
				sb2.append(output[i]).append(" ");
			}
			if(!set.contains(sb2.toString())) {
				set.add(sb2.toString());
				sb.append(sb2).append("\n");
			}
			return;
		}

		for (int i = at; i < N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(i+1, output, depth + 1, M);
				visited[i] = false;
			}
		}

	}

}
//https://www.acmicpc.net/problem/15663