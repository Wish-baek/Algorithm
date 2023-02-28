import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver11653 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int num = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		while (true) {
			for (int i = 2; i <= num; i++) {
				if (isPrime(i) && num % i == 0) {
					while (num % i == 0) {
						num /= i;
						list.add(i);
					}
				}
			}
			if (num == 1)
				break;

		}
		Collections.sort(list);
		for (int i : list) {
			sb.append(i).append("\n");
		}
		System.out.println(sb);

	}

	static boolean isPrime(int n) {
		boolean ck = true;
		for (int i = 2; i < i/2; i++) {
			if (n % i == 0)
				ck = false;
		}
		return ck;
	}

}
//https://www.acmicpc.net/problem/11653