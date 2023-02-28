import java.util.Scanner;

public class Silver6603 {
	static int[] arr, output;
	static boolean[] visited;
	int depth;

	static void perm(int at, int[] arr, int[] output, int depth, int r) {
		if (depth == 6) {
			for (int n : output)
				System.out.print(n + " ");
			System.out.println();
			return;
		}

		for (int i = at; i < arr.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				output[depth] = arr[i];
				perm(i + 1, arr, output, depth + 1, r);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[] num = new int[n];
			for (int i = 0; i < n; i++) {
				num[i] = sc.nextInt();
			}
			output = new int[6];
			visited = new boolean[n];
			perm(0, num, output, 0, 6);
			System.out.println();
		}

	}

}
//https://www.acmicpc.net/problem/6603