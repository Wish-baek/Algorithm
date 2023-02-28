import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Silver24445 {
	static List<ArrayList<Integer>> Node;
	static int[] visited;
	static int R, cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];

		Node = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			Node.add(new ArrayList<>());
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Node.get(a).add(b);
			Node.get(b).add(a);
		}
		for (int i = 1; i < Node.size(); i++) {
			Collections.sort(Node.get(i), Collections.reverseOrder());
		}
		cnt = 1;
		bfs(R);
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}

	}

	static void bfs(int r) {
		Queue<Integer> q = new LinkedList<>();
		visited[r] = cnt;
		q.offer(r);
		while (!q.isEmpty()) {
			int tmp = q.poll();
			for (int i = 0; i < Node.get(tmp).size(); i++) {
				int newNode = Node.get(tmp).get(i);
				if (visited[newNode] == 0) {
					cnt++;
					visited[newNode] = cnt;
					q.offer(newNode);
				}
			}
		}
	}

}
//https://www.acmicpc.net/problem/24445