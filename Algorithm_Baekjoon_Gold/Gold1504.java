import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int to;
	int weight;

	public Node(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {

		return this.weight - o.weight;
	}

}

public class Gold1504 {
	static int N;
	static int[] visited;
	static List<ArrayList<Node>> Graph;
	private static int v1;
	private static int v2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		Graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			Graph.add(new ArrayList<>());
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			Graph.get(a).add(new Node(b, w));
			Graph.get(b).add(new Node(a, w));
		}

		st = new StringTokenizer(br.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());

		// 방법 2
		// 1. 1 -> v1 -> v2 -> N
		// 2. 1 -> v2 -> v1 -> N

//		int r1 = bfs(new Node(1, 0), v1) + bfs(new Node(v1, 0), v2) + bfs(new Node(v2, 0), N);
//		int r2 = bfs(new Node(1, 0), v2) + bfs(new Node(v2, 0), v1) + bfs(new Node(v1, 0), N);

		int a1 = bfs(new Node(1, 0), v1);
		int a2 = bfs(new Node(v1, 0), v2);
		int a3 = bfs(new Node(v2, 0), N);

		int b1 = bfs(new Node(1, 0), v2);
		int b2 = bfs(new Node(v2, 0), v1);
		int b3 = bfs(new Node(v1, 0), N);

		int r1 = -1;
		int r2 = -1;

		boolean check = true;
		boolean check2 = true;

		if (a1 >= 0 && a2 >= 0 && a3 >= 0) {
			r1 = a1 + a2 + a3;

		} else
			check = false;

		if (b1 >= 0 && b2 >= 0 && b3 >= 0) {
			r2 = b1 + b2 + b3;
		} else
			check2 = false;

		if (check == false && check2 == true)
			System.out.println(r2);
		else if (check == true && check2 == false)
			System.out.println(r1);
		else if (check && check2)
			System.out.println(Math.min(r1, r2));
		else
			System.out.println(-1);

//		System.out.println(r1);
//		System.out.println(r2);
//		
//		System.out.println(Math.min(r1, r2));

	}

	static int bfs(Node node, int f) {
		visited = new int[N + 1];

		for (int i = 1; i <= N; i++)
			visited[i] = Integer.MAX_VALUE;

		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(node.to, node.weight));

		visited[node.to] = 0;

		while (!q.isEmpty()) {
			Node tmp = q.poll();
			if (visited[tmp.to] < tmp.weight)
				continue;

			for (int i = 0; i < Graph.get(tmp.to).size(); i++) {

				Node newNode = Graph.get(tmp.to).get(i);
				if (visited[newNode.to] > visited[tmp.to] + Graph.get(tmp.to).get(i).weight) {
					visited[newNode.to] = visited[tmp.to] + Graph.get(tmp.to).get(i).weight;
					q.add(new Node(newNode.to, visited[newNode.to]));
				}

			}
		}
		if (visited[f] == Integer.MAX_VALUE)
			return -1;
		else
			return visited[f];
	}

}
//https://www.acmicpc.net/problem/1504