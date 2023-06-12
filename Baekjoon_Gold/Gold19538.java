import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold19538 {

	static ArrayList<Integer>[] Graph;
	static int[] memo, result;
	static Queue<Integer> q;
	static boolean[] visited;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		Graph = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		memo = new int[N + 1]; // 주변인 수/2

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int cnt = 0;
			while (true) {
				int a = Integer.parseInt(st.nextToken());
				if (a == 0)
					break;
				Graph[i].add(a);
				cnt++;
			}
			memo[i] = (cnt + 1) / 2;
		}

		q = new LinkedList<>();
		visited = new boolean[N + 1];
		result = new int[N + 1]; // 결과 담는 배열

		Arrays.fill(result, -1);

		int count = Integer.parseInt(br.readLine()); // 최초 유포자의 수
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < count; i++) {
			int a = Integer.parseInt(st.nextToken());
			q.add(a);
			result[a] = 0;
		}

		bfs();
		for (int i = 1; i <= N; i++)
			System.out.print(result[i] + " ");
	}

	static void bfs() {

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 0; i < Graph[now].size(); i++) {
				int next = Graph[now].get(i);
				if (next == 0)
					continue;

				memo[next]--; // 루머 믿는 사람 한명 추가

				if (result[next] == -1 && memo[next] == 0) { // 아직 루머를 믿지 않았고 주변인의 절반이 믿었다
					q.add(next);
					result[next] = result[now] + 1;

				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/19538