import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gold1174 {

	static List<Long> list;
	static int[] arr = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		dfs(0, 0);
		Collections.sort(list);

		if (list.size() < n)
			System.out.println(-1);
		else
			System.out.println(list.get(n - 1));
	}

	static void dfs(int depth, long number) {
		if (!list.contains(number))
			list.add(number);
		if (depth >= 10)
			return;

		dfs(depth + 1, number);
		dfs(depth + 1, (number * 10) + arr[depth]);
	}
}
//https://www.acmicpc.net/problem/1174