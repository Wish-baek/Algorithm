import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Gold15686 {
	static int[][] map;
	static List<Node> chicken;
	static List<Node> house;
	static boolean[] visited;
	static int N, M, min;

	static class Node {
		int r;
		int c;

		public Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new ArrayList<>();
		house = new ArrayList<>();

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					house.add(new Node(i, j));
				else if (map[i][j] == 2)
					chicken.add(new Node(i, j));
			}
		}
		visited = new boolean[chicken.size()];
		min = Integer.MAX_VALUE;
		findChicken(0, 0, M);
		System.out.println(min);
	}

	static void findChicken(int at, int depth, int r) {

		if (depth == r) {

			int distSum = 0;

			for (int i = 0; i < house.size(); i++) {
				int minDist = Integer.MAX_VALUE;
				for (int j = 0; j < chicken.size(); j++) {
					if (visited[j] == true) {
						minDist = Math.min(Math.abs(chicken.get(j).r - house.get(i).r)
								+ Math.abs(chicken.get(j).c - house.get(i).c), minDist);
					}
				}
				distSum += minDist;
			}
//			System.out.println(min);
			min = Math.min(min, distSum);

			return;
		}

		for (int i = at; i < chicken.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				findChicken(i + 1, depth + 1, r);
				visited[i] = false;
			}
		}
	}
}
//https://www.acmicpc.net/problem/15686