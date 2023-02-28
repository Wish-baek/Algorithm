import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold1916 {
	public static class Node implements Comparable<Node> {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

		@Override
        public int compareTo(Node o) {
            if(this.weight - o.weight < 0)
                return 1;
            else
                return 0;
        }
	}

	static ArrayList<Node>[] Graph;
	static int[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		Graph = new ArrayList[N + 1];
		visited = new int[N + 1];
		for (int i = 1; i <= N; i++)
			visited[i] = 987654321;

		for (int i = 1; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Graph[a].add(new Node(b, w));
			// Graph.get(b).add(new Node(a, w));
		}
		st = new StringTokenizer(br.readLine(), " ");
		int s = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		bfs(s);
		System.out.println(visited[f]);

	}

	static void bfs(int s) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.offer(new Node(s, 0));

		visited[s] = 0;

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (visited[node.to] < node.weight)
				continue;

			for (int i = 0; i < Graph[node.to].size(); i++) {
				Node newNode = Graph[node.to].get(i);

				if (visited[newNode.to] > visited[node.to] + Graph[node.to].get(i).weight)
					visited[newNode.to] = visited[node.to] + Graph[node.to].get(i).weight;
				q.add(new Node(newNode.to, visited[newNode.to]));

			}

		}
	}

}
