import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Gold9663 {
	static int[] arr;
	static int cnt, N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1];
		cnt = 0;
		setQueen(1);
		System.out.println(cnt);
	}

	static void setQueen(int row) {

		if (!isPossible(row - 1))
			return;

		if (row > N) {
			cnt++;
			return;
		}

		for (int i = 1; i <= N; i++) {
			arr[row] = i;
			setQueen(row + 1);
		}
	}

	static boolean isPossible(int row) {
		for (int i = 1; i < row; i++) {
			if (arr[i] == arr[row] || row - i == Math.abs(arr[row] - arr[i]))
				return false;
		}
		return true;
	}

}
//https://www.acmicpc.net/problem/9663