import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver1049 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int N = Integer.parseInt(st.nextToken()); // 끊어진 기타줄 수
		int M = Integer.parseInt(st.nextToken()); // 기타줄 브랜드 수

		int[] pack = new int[M];
		int[] single = new int[M];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			pack[i] = Integer.parseInt(st.nextToken());
			single[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(pack);
		Arrays.sort(single);

		int pack_min = pack[0];
		int single_min = single[0];

		int result = 0;

		if (single_min * 6 < pack_min) {
			result = N * single_min;
		} else {
			if (N % 6 == 0)
				result = N / 6 * pack_min;
			else
				result = Math.min((N / 6 + 1) * pack_min, N / 6 * pack_min + N % 6 * single_min);
		}
		System.out.println(result);
	}
}
//https://www.acmicpc.net/problem/1049