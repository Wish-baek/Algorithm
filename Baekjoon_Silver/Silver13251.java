import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver13251 {
	static boolean[] visited;
	static int[] arr;
	static int M, sum, K;
	static double result;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		M = Integer.parseInt(br.readLine());

		arr = new int[M];
		sum = 0;

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum += arr[i];
		}

		K = Integer.parseInt(br.readLine());

		result = 0;
		for (int i = 0; i < M; i++) {
			combi(i);
		}

		System.out.println(result);

	}

	static void combi(int depth) {

		if (arr[depth] >= K) {
			int tmp = sum;
			int tmp2 = K;
			double tmpResult = 1;
			while (tmp2-- > 0) {
				tmpResult *= (arr[depth]-- / (double) tmp--);
			}
			result += tmpResult;

		}
		return;
	}

}
//https://www.acmicpc.net/problem/13251