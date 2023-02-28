import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Gold13023 {
	static boolean[] visited;
	static List<ArrayList<Integer>> Node;
	static int result;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		
		Node = new ArrayList<>();
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			Node.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			Node.get(a).add(b);
			Node.get(b).add(a);
		}
		result = 0;
		for(int i = 0; i <N; i++) {
			visited[i] = true;
			dfs(N, i, 0);
			visited[i] = false;
		}
		
		System.out.println(0);

	}

	static void dfs(int N, int n, int d) {

		if (d == 4) {
			System.out.println(1);
			System.exit(0);
		}

		for (int i = 0; i < Node.get(n).size(); i++) {
			int newNode = Node.get(n).get(i);

			if (!visited[newNode]) {
				 visited[newNode] = true;
				dfs(N, newNode, d + 1);
				visited[newNode] = false;

			}
		}
	}
}
//https://www.acmicpc.net/problem/13023