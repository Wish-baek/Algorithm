import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze5585 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = 1000 - Integer.parseInt(br.readLine());

		int sum = 0;

		sum += N / 500;
		N %= 500;
		sum += N / 100;
		N %= 100;
		sum += N / 50;
		N %= 50;
		sum += N / 10;
		N %= 10;
		sum += N / 5;
		N %= 5;
		sum += N;
		System.out.println(sum);

	}

}
//https://www.acmicpc.net/problem/5585