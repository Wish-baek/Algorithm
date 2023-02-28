import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Silver1476 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int E = Integer.valueOf(st.nextToken());
		int S = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int e = 1;
		int s = 1;
		int m = 1;
		if (E == 15 && S == 28 && M == 19) {
			System.out.println(E * S * M);
			System.exit(0);
		}

		int year = 1;

		while (true) {
			if (e == E && s == S && m == M)
				break;

			e++;
			s++;
			m++;

			if (e == 16)
				e = 1;
			if (s == 29)
				s = 1;
			if (m == 20)
				m = 1;
			year++;
		}
		System.out.println(year);
	}

}
