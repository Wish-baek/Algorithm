import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Silver24480 {
	static List<ArrayList<Integer>> Node;
	static int[] visited;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());

		Node = new ArrayList<>();
		visited = new int[N + 1];
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

		for (int i = 1; i <= N; i++) {
			Collections.sort(Node.get(i), Collections.reverseOrder());
		}
		cnt = 1;
		dfs(R);
		for (int i = 1; i <= N; i++) {
			System.out.println(visited[i]);
		}
	}

	static void dfs(int r) {
		Stack<Integer> stack = new Stack<>();
		visited[r] = cnt;
		stack.add(r);

		int tmp = stack.pop();
		for (int i = 0; i < Node.get(tmp).size(); i++) {
			int newNode = Node.get(tmp).get(i);
			if (visited[newNode] == 0) {
				cnt++;
				visited[newNode] = cnt;
				dfs(newNode);
			}
		}

	}

}
//https://www.acmicpc.net/problem/24480