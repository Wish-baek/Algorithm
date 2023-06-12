import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Gold13265 {
	static ArrayList<Integer>[] graph;
	static int[] colors;
	static boolean isFail;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			graph = new ArrayList[n + 1];
			colors = new int[n + 1];
			isFail = false;

			for (int i = 1; i <= n; i++)
				graph[i] = new ArrayList<>();

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}

			for (int i = 1; i <= n; i++) {
				if (isFail)
					break;
				if (colors[i] == 0) { // 색칠 안 되어 있다면
					colors[i] = -1;
					dfs(i);
				}
			}
			System.out.println(isFail ? "impossible" : "possible");
		}
	}

	static void dfs(int idx) {
		if (isFail) {
			return;
		}

		for (int i = 0; i < graph[idx].size(); i++) {
			int next = graph[idx].get(i);

			if (colors[next] == 0) { // 아직 색칠 안했다면
				colors[next] = colors[idx] * -1; // 인접한 노드와 다른 색으로 색칠
				dfs(next);
			}

			if (colors[next] == colors[idx]) { // 인접한 노드와 색이 같다면
				isFail = true;
				return;
			}
		}
	}
}
//https://www.acmicpc.net/problem/13265