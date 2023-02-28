import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bronze5355 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			double n = Double.parseDouble(st.nextToken());
			while (st.hasMoreTokens()) {
				char c = st.nextToken().charAt(0);
				if (c == '@')
					n *= 3;
				else if (c == '%')
					n += 5;
				else if (c == '#')
					n -= 7;
			}
			System.out.printf("%.2f \n", n);
		}
	}
}
//https://www.acmicpc.net/problem/5355