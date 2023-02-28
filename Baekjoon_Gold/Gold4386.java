import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gold4386 {

	static List<Node>[] Graph;
	static boolean[] visited;
	static List<double[]> list;
	static double res;
	static int n;

	static class Node implements Comparable<Node> {
		int to;
		double dist;

		public Node(int to, double dist) {
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Node o) {
			if (this.dist > o.dist)
				return 1;
			else if (this.dist < o.dist)
				return -1;
			else
				return 0;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		Graph = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++) {
			Graph[i] = new ArrayList<>();
		}

		list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			list.add(new double[] { x, y });
		}

		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				double x1 = list.get(i)[0];
				double y1 = list.get(i)[1];
				double x2 = list.get(j)[0];
				double y2 = list.get(j)[1];
				Graph[i].add(new Node(j, Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))));
				Graph[j].add(new Node(i, Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2))));

			}
		}

			System.out.printf("%.2f\n", star());
//		for(int i = 0; i<Graph.length; i++) {
//			for(int j = 0; j<Graph[i].size(); j++) {
//				System.out.print(Graph[i].get(j).to + " " +Graph[i].get(j).dist);
//			}System.out.println();
//		}System.out.println();

	}

	static double star() {
		visited = new boolean[n];
		PriorityQueue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, 0));
		res = 0;
		while (!q.isEmpty()) {
			Node node = q.poll();
			if (!visited[node.to]) {
				visited[node.to] = true;
				res += node.dist;

				for (int i = 0; i < Graph[node.to].size(); i++) {
					Node newNode = Graph[node.to].get(i);
					q.add(new Node(newNode.to, newNode.dist));
				}

			}
		}
		return res;

	}

}
