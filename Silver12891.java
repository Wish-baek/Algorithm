import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver12891 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int S = Integer.valueOf(st.nextToken());
		int P = Integer.valueOf(st.nextToken());

		String str = br.readLine();

		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.valueOf(st.nextToken());
		int C = Integer.valueOf(st.nextToken());
		int G = Integer.valueOf(st.nextToken());
		int T = Integer.valueOf(st.nextToken());

		int count = 0;
		int a = 0;
		int c = 0;
		int g = 0;
		int t = 0;
		for (int j = 0; j < P; j++) {
			if (str.charAt(j) == 'A')
				a++;
			else if (str.charAt(j) == 'C')
				c++;
			else if (str.charAt(j) == 'G')
				g++;
			else if (str.charAt(j) == 'T')
				t++;
		}
		if (a >= A && c >= C && g >= G && t >= T)
			count++;
		for (int i = 1; i < S - P + 1; i++) {

			if (str.charAt(i - 1) == 'A')
				a--;
			else if (str.charAt(i - 1) == 'C')
				c--;
			else if (str.charAt(i - 1) == 'G')
				g--;
			else if (str.charAt(i - 1) == 'T')
				t--;

			if (str.charAt(i + P - 1) == 'A')
				a++;
			else if (str.charAt(i + P - 1) == 'C')
				c++;
			else if (str.charAt(i + P - 1) == 'G')
				g++;
			else if (str.charAt(i + P - 1) == 'T')
				t++;

			if (a >= A && c >= C && g >= G && t >= T)
				count++;
		}

		System.out.println(count);
	}

}
//https://www.acmicpc.net/problem/12891