import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Silver2529 {
	static List<String> list;
	static int N;
	static BigInteger max, min;
	static String maxString, minString;
	static char[] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N];
		list = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		max = BigInteger.valueOf(-1);
		min = BigInteger.valueOf(987654321);

		for (int i = 0; i <= 9; i++) {
			visited = new boolean[10];
			visited[i] = true;
			dfs(0, i, Integer.toString(i));
		}

		Collections.sort(list);

		System.out.println(list.get(list.size() - 1));
		System.out.println(list.get(0));
	}

	static void dfs(int idx, int before, String sum) {

		if (idx == N) {
			list.add(sum);
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (!visited[i]) {
				visited[i] = true;
				if (arr[idx] == '<' && before < i) {
					dfs(idx + 1, i, sum + Integer.toString(i));
				} else if (arr[idx] == '>' && before > i)
					dfs(idx + 1, i, sum + Integer.toString(i));
				visited[i] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/2529