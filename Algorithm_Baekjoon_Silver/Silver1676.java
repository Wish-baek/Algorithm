import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver1676 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());
		int count = 0;
		int cnt2 = 0;
		int cnt5 = 0;

		for (int i = 1; i <= num; i++) {
			int tmp = i;

			while (tmp % 5 == 0) {
				cnt5++;
				tmp /= 5;

			}
			while (tmp % 2 == 0) {
				cnt2++;
				tmp /= 2;

			}
		}

		System.out.println(Math.min(cnt2, cnt5));
	}

}
//https://www.acmicpc.net/problem/1676