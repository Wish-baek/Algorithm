import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gold1038 {
	static List<Long> list;
	static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		dfs(0, 0);
		Collections.sort(list);
		if (list.size() < N || N > 1022)
			System.out.println(-1);
		else
			System.out.println(list.get(N));
	}

	static void dfs(int idx, long sum) {
		if (!list.contains(sum))
			list.add(sum);
		if (idx >= 10) {
			return;
		}
		dfs(idx + 1, sum);
		dfs(idx + 1, sum * 10 + arr[idx]);
	}
}
//https://www.acmicpc.net/problem/1038