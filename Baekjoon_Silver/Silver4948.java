import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Silver4948 {
	static int[] arr;

	private static int sosu(int n) {
		int cnt = 0;
		for (int i = n + 1; i <= n * 2; i++) {

			if (arr[i] != 0)
				cnt++;
		}
		return cnt;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[123456 * 2 + 1];
		for (int i = 2; i <= arr.length - 1; i++) {
			arr[i] = i;
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == 0)
				continue;

			for (int j = 2 * i; j <= arr.length; j += i) {
				arr[j] = 0;
			}
		}
		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0)
				break;
			System.out.println(sosu(num));
		}

	}

}
//https://www.acmicpc.net/problem/11653