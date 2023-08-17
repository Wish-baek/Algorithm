import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold17616 {
	static int N, X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken()); // 학생 수
		int M = Integer.parseInt(st.nextToken()); // M번 질문
		X = Integer.parseInt(st.nextToken()); // 찾을 학생 X의 등수

		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		ArrayList<Integer>[] graph_r = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
			graph_r[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			graph[A].add(B); // A -> B
			graph_r[B].add(A); // B -> A
		}

		System.out.println((1 + bfs(graph_r)) + " " + (N - bfs(graph)));
	}

	static int bfs(ArrayList<Integer>[] graph) {

		boolean[] visited = new boolean[N + 1];

		Queue<Integer> q = new LinkedList<>();

		q.add(X);
		visited[X] = true;

		int cnt = 0;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int next : graph[now]) {
				if (!visited[next]) {
					visited[next] = true;
					q.add(next);
					cnt++;
				}
			}

		}
		return cnt;
	}
}

// https://www.acmicpc.net/problem/17616