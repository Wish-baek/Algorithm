import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver18870 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		int[] sorted = new int[n];

		Map<Integer, Integer> map = new HashMap<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(st.nextToken());
			sorted[i] = arr[i];
		}

		Arrays.sort(sorted);
		int rank = 0;

		for (int i = 0; i < sorted.length; i++) {
			if (!map.containsKey(sorted[i]))
				map.put(sorted[i], rank++);
		}

		for (int num : arr) {
			sb.append(map.get(num)).append(" ");
		}
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/18870