import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Silver10814 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		String[][] arr = new String[n][2];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			arr[i][0] = str[0];
			arr[i][1] = str[1];
		}

		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				return Integer.valueOf(o1[0]) - Integer.valueOf(o2[0]);
			}

		});
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/11650
