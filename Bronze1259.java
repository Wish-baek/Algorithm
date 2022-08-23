import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		boolean check;
		while (true) {
			str = br.readLine();
			if (Integer.parseInt(str) == 0)
				break;

			check = true;
			int n = str.length() - 1;
			for (int i = 0; i < str.length() / 2; i++) {
				if (str.charAt(i) != str.charAt(n - i)) {
					check = false;
					break;
				}
			}
			if (check == true)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
//https://www.acmicpc.net/problem/1259