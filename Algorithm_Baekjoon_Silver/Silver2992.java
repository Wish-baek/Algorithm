import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver2992 {
	static boolean[] visited;
	static String[] arr;
	static int X, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		arr = Integer.toString(X).split("");

		visited = new boolean[arr.length];

		min = Integer.MAX_VALUE;
		perm(0, arr.length, "");

//		Collections.sort(list);
		if (min == Integer.MAX_VALUE)
			System.out.println(0);
		else
			System.out.println(min);
	}

	static void perm(int depth, int r, String str) {
		if (depth == r) {
			int tmp = Integer.parseInt(str);
			if (tmp > X)
				min = Math.min(min, tmp);
			return;
		}

		for (int i = 0; i < r; i++) {
			if (!visited[i]) {
				visited[i] = true;
				perm(depth + 1, r, str + arr[i]);
				visited[i] = false;
			}
		}

	}
}
//https://www.acmicpc.net/problem/2992