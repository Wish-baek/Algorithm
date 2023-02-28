import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Gold9466 {
	static int cnt;
	static int[] Graph;
	static boolean[] visited;
	static boolean[] isTeam;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");

			Graph = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				Graph[i] = Integer.parseInt(st.nextToken());
			}

			visited = new boolean[N + 1];
			isTeam = new boolean[N + 1];
			cnt = 0;

			for (int i = 1; i <= N; i++) {
				if (!isTeam[i])
					dfs(i);
			}

			System.out.println(N - cnt);
		}
	}

	static void dfs(int n) {
		if (visited[n]) {
			isTeam[n] = true;
			cnt++;
		} else {
			visited[n] = true;
		}

		if (!isTeam[Graph[n]]) {
			dfs(Graph[n]);
		}

		visited[n] = false;
		isTeam[n] = true;
	}
}
//https://www.acmicpc.net/problem/9466