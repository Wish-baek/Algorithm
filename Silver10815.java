import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Silver10815 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.valueOf(br.readLine());

		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr.add(Integer.valueOf(st.nextToken()));
		}

		int m = Integer.valueOf(br.readLine());
		str = br.readLine();
		st = new StringTokenizer(str, " ");	
		Collections.sort(arr);
		for (int i = 0; i < m; i++) {
			if (binarySearch(arr,  Integer.valueOf(st.nextToken())))
				System.out.print(1 + " ");
			else
				System.out.print(0 + " ");
		}

	}

	public static boolean binarySearch(ArrayList<Integer> arr, int target) {
		int start = 0;
		int end = arr.size() - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (arr.get(mid) == target)
				return true;
			else if (arr.get(mid) < target) {
				start = mid + 1;
			} else if (arr.get(mid) > target) {
				end = mid - 1;
			}
		}
		return false;
	}

}
