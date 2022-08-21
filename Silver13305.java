import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Silver13305 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		long[] dist = new long[N - 1];
		long[] fee = new long[N];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N - 1; i++) {
			dist[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			fee[i] = Integer.parseInt(st.nextToken());
		}

		long result = 0;
		long min = fee[0];
		for (int i = 0; i < N - 1; i++) {
			if (fee[i] < min)
				min = fee[i];
			result += min * dist[i];
		}

		System.out.println(result);

	}

}
//https://www.acmicpc.net/problem/13305