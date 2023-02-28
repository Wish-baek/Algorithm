import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Silver1920 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.valueOf(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int[] arr = new int[N];

		for (int i = 0; i < N; i++) { // 탐색할 배열에 요소 삽입
			arr[i] = Integer.valueOf(st.nextToken());
		}

		Arrays.sort(arr);

		int M = Integer.valueOf(br.readLine());

		st = new StringTokenizer(br.readLine(), " ");

		for (int i = 0; i < M; i++) {
			int num = Integer.valueOf(st.nextToken());
			if (binarySearch(arr, num))
				sb.append(1);
			else
				sb.append(0);
			sb.append("\n");
		}

		System.out.println(sb);

	}

	public static boolean binarySearch(int[] arr, int num) {
		int start = 0;
		int end = arr.length - 1;
		int mid;

		while (start <= end) {
			mid = (start + end) / 2;

			if (num == arr[mid])
				return true;
			else if (num < arr[mid])
				end = mid - 1;
			else
				start = mid + 1;
		}

		return false;

	}

}
//https://www.acmicpc.net/problem/1920