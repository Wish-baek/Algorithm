import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold13418 {
	static List<Node>[] Graph;
	static boolean[] visited;
	static int N;

	static class Node {
		int to;
		int weight;

		public Node(int to, int weight) {
			this.to = to;
			this.weight = weight;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Graph = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			Graph[i] = new ArrayList<>();
		}
		boolean start = false;
		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			Graph[a].add(new Node(b, c));
			Graph[b].add(new Node(a, c));
			if (a == 0 && b == 1 || a == 1 && b == 0) {
				if (c == 1)
					start = false;
				else
					start = true;
			}
		}
		int max = (int) Math.pow(badRoute(), 2);
		int min = (int) Math.pow(goodRoute(), 2);
		System.out.println(Math.abs(max - min));

	}

	static int badRoute() {
		visited = new boolean[N + 1];
		PriorityQueue<Node> q1 = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Gold13418.Node o2) {
				return o1.weight - o2.weight;
			}
		});

		q1.add(new Node(0, -1));
		int res = 0;
		while (!q1.isEmpty()) {
			Node node = q1.poll();
			int now = node.to;
			int w = node.weight;

			if (!visited[now]) {
				if (w == 0)
					res++;
				visited[now] = true;
				for (int i = 0; i < Graph[now].size(); i++) {
					Node newNode = Graph[now].get(i);

					q1.add(new Node(newNode.to, newNode.weight));

				}
			}
		}
		return res;
	}

	static int goodRoute() {
		visited = new boolean[N + 1];
		PriorityQueue<Node> q2 = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Gold13418.Node o2) {
				return o2.weight - o1.weight;
			}
		});
		q2.add(new Node(0, -1));
		int res = 0;
		while (!q2.isEmpty()) {
			Node node = q2.poll();
			int now = node.to;
			int w = node.weight;

			if (!visited[now]) {
				if (w == 0)
					res++;
				visited[now] = true;
				for (int i = 0; i < Graph[now].size(); i++) {
					Node newNode = Graph[now].get(i);

					q2.add(new Node(newNode.to, newNode.weight));
				}

			}
		}
		return res;
	}

}
//https://www.acmicpc.net/problem/13418