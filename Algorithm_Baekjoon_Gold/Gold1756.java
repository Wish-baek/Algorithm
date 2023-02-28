import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Gold1756 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());

		int[] depthArr = new int[D];
		boolean[] isPizza = new boolean[D];

		int[] pizza = new int[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < D; i++) {
			depthArr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}

		int cnt = 0;
		int result = -1;
		int last = -1;

		for (int i = 0; i < N; i++) {
			int len = pizza[i];
			boolean ck = false;
			for (int j = 0; j < D; j++) {
				if (isPizza[j] && j != 0) {
					isPizza[j - 1] = true;
					cnt++;
					last = j - 1;
					ck = true;
				} else if (depthArr[j] < len && j != 0) {
					isPizza[j - 1] = true;
					cnt++;
					last = j - 1;
					ck = true;
				}

				if (ck)
					break;
			}
		}

		if (cnt != N)
			System.out.println(0);
		else
			System.out.println(last + 1);
	}
}
//https://www.acmicpc.net/problem/1756