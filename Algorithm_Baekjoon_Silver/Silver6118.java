import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver6118 {
	static List<ArrayList<Integer>> Node;
	static boolean[] visited;
	static int minNum, maxDist, cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken()); // 정점 수
		int M = Integer.parseInt(st.nextToken()); // 간선 수
		Node = new ArrayList<>();
		minNum = Integer.MAX_VALUE;
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			Node.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Node.get(a).add(b);
			Node.get(b).add(a);
		}

		bfs();
		sb.append(minNum).append(" ").append(maxDist).append(" ").append(cnt);

		System.out.println(sb);

	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited[1] = true;
		q.add(new int[] { 1, 0 });

		while (!q.isEmpty()) {
			int[] tmp = q.poll();
			int num = tmp[0];
			int dist = tmp[1];

			if (dist > maxDist) {
				minNum =num;
				maxDist = dist;
				cnt = 1;
			} else if (dist == maxDist) {
				minNum = Math.min(minNum, num);
				cnt++;
			}

			for (int i = 0; i < Node.get(num).size(); i++) {

				int newNode = Node.get(num).get(i);
				if (!visited[newNode]) {
					q.offer(new int[] { newNode, dist + 1 });
					visited[newNode] = true;
				}
			}
		}
	}
}
//https://www.acmicpc.net/problem/6118