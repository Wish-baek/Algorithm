import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Silver21937 {
	static List<Integer>[] Graph;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[b].add(a);
		}

		int X = Integer.parseInt(br.readLine());
		dfs(X);
		System.out.println(cnt);

	}

	static void dfs(int now) {
		visited[now] = true;

		for (int i = 0; i < Graph[now].size(); i++) {
			int next = Graph[now].get(i);
			if (!visited[next]) {
				dfs(next);
				cnt++;
			}
		}
	}
}
//https://www.acmicpc.net/problem/21937