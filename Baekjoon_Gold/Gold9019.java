import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold9019 {
	static String[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			visited = new String[10001];
			bfs(A, B);
			System.out.println(visited[B]);
		}

	}

	static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = "";
		while (!q.isEmpty()) {
			int now = q.poll();

			int d = (now * 2) % 10000;
			int s = (now == 0) ? 9999 : now - 1;
			int l = (now % 1000) * 10 + now / 1000;
			int r = (now % 10) * 1000 + now / 10;

			if (visited[d] == null) { // D
				visited[d] = visited[now] + "D";
				q.add(d);
			}
			if (visited[s] == null) { // S
				visited[s] = visited[now] + "S";
				q.add(s);
			}

			if (visited[l] == null) { // L
				visited[l] = visited[now] + "L";
				q.add(l);
			}

			if (visited[r] == null) { // R
				visited[r] = visited[now] + "R";
				q.add(r);
			}
		}
	}

}
//https://www.acmicpc.net/problem/9019