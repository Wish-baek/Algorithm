import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver25206 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		double total_credit = 0;
		double total_score = 0;
		for (int i = 0; i < 20; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();

			double score = 0;

			double credit = Double.parseDouble(st.nextToken());

			String grade = st.nextToken();

			if (grade.equals("P"))
				continue;
			total_credit += credit;

			if (grade.equals("F"))
				continue;
			char a = grade.charAt(0);
			char b = grade.charAt(1);

			if (a == 'A') {
				score += 4;
				if (b == '+')
					score += 0.5;
			} else if (a == 'B') {
				score += 3;
				if (b == '+')
					score += 0.5;
			} else if (a == 'C') {
				score += 2;
				if (b == '+')
					score += 0.5;
			} else if (a == 'D') {
				score += 1;
				if (b == '+')
					score += 0.5;
			}

			total_score += score * credit;
		}

		double result = total_score / total_credit;
		System.out.printf("%f", result);
	}
}
// https://www.acmicpc.net/problem/25206