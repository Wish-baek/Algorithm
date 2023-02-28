import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver16198 {
	static int N, max;
	static List<Integer> list;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}

		dfs(list, 0, 0);
		System.out.println(max);
	}

	static void dfs(List<Integer> list, int depth, int sum) {

		if (list.size() < 3) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 1; i < list.size() - 1; i++) {
			List<Integer> tmpList = new ArrayList<>(list);
			tmpList.remove(i);
			dfs(tmpList, depth + 1, sum + list.get(i - 1) * list.get(i + 1));
		}
	}
}
//https://www.acmicpc.net/problem/16198