import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Silver24482 {

	static List<Integer>[] Graph;
	static int[] depth;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[N + 1];
		depth = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
			depth[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Graph[a].add(b);
			Graph[b].add(a);
		}

		for (int i = 1; i <= N; i++) {
			Collections.sort(Graph[i], Collections.reverseOrder());
		}
		depth[R] = 0;

		dfs(R);

		for (int i = 1; i <= N; i++) {
			System.out.println(depth[i]);
		}

	}

	static void dfs(int node) {

		for (int i = 0; i < Graph[node].size(); i++) {
			int newNode = Graph[node].get(i);
			if (depth[newNode] == -1) {
				depth[newNode] = depth[node] + 1;
				dfs(newNode);
			}
		}
	}

}
//https://www.acmicpc.net/problem/24482