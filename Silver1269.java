import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Silver1269 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int[] A = new int[a];
		int[] B = new int[b];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < a; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			A[i] = tmp;
		}

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < b; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			B[i] = tmp;
		}

		Arrays.sort(A);
		Arrays.sort(B);
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < a; i++) {
			if(!binarySearch(B, A[i])) set.add(A[i]);
		}
		for (int i = 0; i < b; i++) {
			if(!binarySearch(A, B[i])) set.add(B[i]);
		}
		
		System.out.println(set.size());
	}

	static boolean binarySearch(int[] arr, int n) {
		int start = 0;
		int end = arr.length - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;
			if (n == arr[mid])
				return true;
			else if (n < arr[mid]) {
				end = mid - 1;
			} else if (n > arr[mid]) {
				start = mid + 1;
			}
		}

		return false;

	}

}
//https://www.acmicpc.net/problem/1269
