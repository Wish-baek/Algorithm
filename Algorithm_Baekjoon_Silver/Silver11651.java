import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Silver11651 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.valueOf(br.readLine());
		int[][] arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			String[] str = br.readLine().split(" ");
			for (int j = 0; j < 2; j++) {
				arr[i][j] = Integer.valueOf(str[j]);
			}
		}

		Arrays.sort(arr, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				} else {
					return o1[1] - o2[1];
				}
			}

		});
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				sb.append(arr[i][j]).append(" ");
			}sb.append("\n");
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/11651
