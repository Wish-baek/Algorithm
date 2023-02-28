import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bronze4388 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		while (true) {
			st = new StringTokenizer(br.readLine(), " ");
			String[] atmp = st.nextToken().split("");
			String[] btmp = st.nextToken().split("");
			if (atmp[0].equals("0") & btmp[0].equals("0"))
				break;
			int max = Math.max(atmp.length, btmp.length);
			int[] a = new int[max];
			int[] b = new int[max];

			for (int i = 0; i < atmp.length; i++) {
				a[atmp.length - i - 1] = Integer.parseInt(atmp[i]);
			}
			for (int i = 0; i < btmp.length; i++) {
				b[btmp.length - i - 1] = Integer.parseInt(btmp[i]);
			}
//		System.out.println(Arrays.toString(a));
//		System.out.println(Arrays.toString(b));
			int cnt = 0;

			for (int i = 1; i < Math.min(a.length, b.length); i++) {
				int tmp = a[i - 1] + b[i - 1];
				if (tmp >= 10) {
					a[i] += 1;
					cnt++;
				}
			}
			if (a[a.length - 1] + b[b.length - 1] >= 10)
				cnt++;
			System.out.println(cnt);

		}
	}
}
//https://www.acmicpc.net/problem/4388