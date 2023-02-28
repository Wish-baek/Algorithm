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

public class Silver2606 {
	static List<ArrayList<Integer>> Node;
	static boolean[] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 정점 수
		int M = Integer.parseInt(br.readLine()); // 간선 수
		Node = new ArrayList<>();
		visited = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			Node.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Node.get(a).add(b);
			Node.get(b).add(a);
		}
		for (int i = 1; i <= N; i++) {
			Collections.sort(Node.get(i));
		}
		
//		for(int i = 0; i < Node.size(); i++) {
//			for(int j = 0; j < Node.get(i).size(); j++) {
//				System.out.print(Node.get(i).get(j));
//			}
//			System.out.println();
//		}
		
		bfs(1);
		System.out.println(cnt);
	}

	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		visited[n] = true;
		q.offer(n);

		while (!q.isEmpty()) {

			int tmp = q.poll();
			for (int i = 0; i < Node.get(tmp).size(); i++) {
				int newNode = Node.get(tmp).get(i);
				if (!visited[newNode]) {
					visited[newNode] = true;
					q.offer(newNode);
					cnt++;
				}
			}

		}

	}

}
//https://www.acmicpc.net/problem/2606