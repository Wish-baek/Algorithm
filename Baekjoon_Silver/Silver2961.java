import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver2961 {
	static long min = Long.MAX_VALUE;
	static long[][] flavor;

	static void combination(int idx, long s, long c) {

		if (idx == flavor.length) {
			if (Math.abs(s - c) < min && s!=0 && c!=0)
				min = Math.abs(s - c);
			return;

		}
		if (s == 0) {
			combination(idx + 1, flavor[idx][0], c + flavor[idx][1]);
			combination(idx + 1, s, c);
		} else {
			combination(idx + 1, s * flavor[idx][0], c + flavor[idx][1]);
			combination(idx + 1, s, c);
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(); // int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		flavor = new long[T][2];
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			flavor[i][0] = Integer.parseInt(st.nextToken());
			flavor[i][1] = Integer.parseInt(st.nextToken());
		}

		combination(0, 0, 0);
		System.out.print(min);
	}
}
//https://www.acmicpc.net/problem/2961