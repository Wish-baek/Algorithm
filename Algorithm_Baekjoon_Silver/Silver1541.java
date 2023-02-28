import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Silver1541 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int num_cnt = 1;
		int sym_cnt = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i - 1) == '+' && Character.isDigit(str.charAt(i))
					|| str.charAt(i - 1) == '-' && Character.isDigit(str.charAt(i)))
				num_cnt++;
			else if (str.charAt(i) == '+' || str.charAt(i) == '-')
				sym_cnt++;
		}

		StringTokenizer st = new StringTokenizer(str, "+-");

		int[] num = new int[num_cnt];
		int size = 0;
		char[] sym = new char[sym_cnt];
		int size2 = 0;

		while (st.hasMoreTokens()) {
			num[size++] = Integer.parseInt(st.nextToken());
		}

		
		
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == '+')
				sym[size2++] = '+';
			else if (str.charAt(i) == '-')
				sym[size2++] = '-';
		}

		int minus = -1;

		for (int i = 0; i < sym.length; i++) {
			if (sym[i] == '-') {
				minus = i;
				break;
			}
		}
		
		if(minus==-1) {
			int sum = 0;
			for (int i = 0; i<num.length; i++) {
				sum += num[i];
			}
			System.out.println(sum);
		}
		else {
		int sum = 0;
		for (int i = 0; i <= minus; i++) {
			sum += num[i];
		}
		for (int i = minus+1; i< num.length; i++) {
			sum -= num[i];
		}
		System.out.println(sum);
		}
	}

}
//https://www.acmicpc.net/problem/1541