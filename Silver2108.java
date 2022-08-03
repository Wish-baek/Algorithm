import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Silver2108 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(br.readLine());
		int[] arr = new int[n];

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		double sum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.valueOf(br.readLine());
			sum += arr[i];
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			map.put(arr[i], 0);
		}

		for (int i = 0; i < n; i++) {
			map.put(arr[i], map.get(arr[i]) + 1);
		}

		ArrayList<Integer> keyset = new ArrayList<>(map.keySet());
		ArrayList<Integer> bin = new ArrayList<>();
		int max = 0;
		int cnt = 0;
		int index = 0;
		for (int i = 0; i < keyset.size(); i++) {
			if (map.get(keyset.get(i)) > max) {
				max = map.get(keyset.get(i));
				index = keyset.get(i);
			}
		}

		for (int i = 0; i < keyset.size(); i++) {
			if (map.get(keyset.get(i)) == max) {
				bin.add(keyset.get(i));
			}
		}

		Collections.sort(bin);
		Collections.sort(keyset);

		System.out.println(Math.round(sum / n));
		System.out.println(arr[n / 2]);
		if (bin.size() > 1)
			System.out.println(bin.get(1));
		else
			System.out.println(index);
		System.out.println(Math.abs(keyset.get(keyset.size() - 1) - keyset.get(0)));

	}
}
//https://www.acmicpc.net/problem/2108