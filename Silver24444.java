import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Silver24444 {

	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] check;
	static int cnt;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken()); // 정점의 수
		int M = Integer.parseInt(st.nextToken()); // 간선의 수
		int R = Integer.parseInt(st.nextToken()); // 시작 정점

		check = new int[N + 1];

		for (int i = 0; i < N + 1; i++) {
			graph.add(new ArrayList<Integer>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine(), " ");
			int U = Integer.parseInt(st.nextToken());
			int V = Integer.parseInt(st.nextToken());
			
			graph.get(U).add(V);
			graph.get(V).add(U);
		}
		
		for(int i = 1; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}
		
		cnt = 1;
		bfs(R);
		
		for(int i = 1; i < check.length; i++) {
			sb.append(check[i]).append("\n");
		}
		System.out.println(sb);


	}
	
	static void bfs(int node) {
		check[node] = cnt;
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(node);
		
		while(!q.isEmpty()) {
			int num = q.poll();
			for(int i = 0; i < graph.get(num).size(); i++) {
				int newNode = graph.get(num).get(i);
				if(check[newNode]==0) {
					cnt++;
					check[newNode] = cnt;
					q.offer(newNode);
				}
			}
		}
		
	}

}
//https://www.acmicpc.net/problem/24444