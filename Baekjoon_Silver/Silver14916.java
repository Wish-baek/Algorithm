import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver14916 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n/2+1; i++) { // 5
			for (int j = 0; j < n/2+1; j++) { // 2
				if (i * 5 + j * 2 == n) {
//					System.out.println(i + " " + j);
					min = Math.min(min, i + j);
				}

			}
		}
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

}
//https://www.acmicpc.net/problem/14916