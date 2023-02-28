import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1032 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine();
		}

		for (int i = 0; i < arr[0].length(); i++) {
			boolean ck = true;
			char tmp = arr[0].charAt(i);
			for (int j = 0; j < N; j++) {
				if (arr[j].charAt(i) != tmp) {
					ck = false;
					break;
				}
			}
			if (ck == false)
				System.out.print("?");
			else
				System.out.print(tmp);
		}
	}

}
//https://www.acmicpc.net/problem/1032