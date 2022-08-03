import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Bronze2309 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int[] arr = new int[9];

		for (int i = 0; i < 9; i++) {
			arr[i] = Integer.valueOf(br.readLine());
		}
		int not1 = -1;
		int not2 = -1;
		int cnt=1;
		for (int i = 0; i < 9; i++) {
			for (int j = i + 1; j < 9; j++) {
				int sum = 0;
				for (int a = 0; a < 9; a++) {
					if (a != i && a != j)	{
						sum += arr[a];
					}
				}
				if (sum == 100) {
					not1 = i;
					not2 = j;
				}
			}
		}
		ArrayList<Integer> arr2 = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			if (i != not1 && i != not2) {
				arr2.add(arr[i]);
			}
		}
		Collections.sort(arr2);
		for (int i = 0; i < 7; i++) {
			sb.append(arr2.get(i)).append("\n");
		}
		System.out.println(sb);

	}

}
