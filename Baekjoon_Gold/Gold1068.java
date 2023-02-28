import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold1068 {
	static List<Integer>[] Graph;
	static int result, root;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		Graph = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			Graph[i] = new ArrayList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		root = -1;
		int remove = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(st.nextToken());
			if (n == -1)
				root = i;
			if (i == remove || n == remove || n == -1)
				continue;
			Graph[n].add(i);
		}

		if (Graph[root].isEmpty() && root == remove)
			System.out.println(0);
		else if (Graph[root].isEmpty() && root != remove)
			System.out.println(1);
		else {
			dfs(root);
			System.out.println(result);
		}
	}

	static void dfs(int now) {
		if (Graph[now].isEmpty()) {
			if (now != root)
				result++;
			return;
		}

		for (int i = 0; i < Graph[now].size(); i++) {
			dfs(Graph[now].get(i));
		}
	}
}
//https://www.acmicpc.net/problem/1068