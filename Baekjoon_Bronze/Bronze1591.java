import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1591 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {

			int num = Integer.parseInt(br.readLine());
			if((num&(-num))==num) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb);

	}
}
//https://www.acmicpc.net/problem/15917