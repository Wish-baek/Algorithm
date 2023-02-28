import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Silver11931 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());

		Integer[] arr = new Integer[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		Arrays.sort(arr, Comparator.reverseOrder());

		for (int num : arr)
			sb.append(num).append("\n");
		System.out.println(sb);
	}
}
//https://www.acmicpc.net/problem/11931