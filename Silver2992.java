import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Silver2992 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());

		char[] arr = Integer.toString(X).toCharArray();
		Arrays.sort(arr);
		int n = X + 1;

		while (true) {
			boolean ck = true;
			char[] tmp = Integer.toString(n).toCharArray();
			if (tmp.length != arr.length) {
				System.out.println(0);
				System.exit(0);
			}
			Arrays.sort(tmp);
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i] != arr[i]) {
					ck = false;
					break;
				}
			}
//			System.out.println(ck);
			if (ck == true) {
				System.out.println(n);
				System.exit(0);
			}
			n++;

		}

	}

}
//https://www.acmicpc.net/problem/2992