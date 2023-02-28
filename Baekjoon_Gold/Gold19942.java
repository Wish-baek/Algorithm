import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Gold19942 {
	static int[][] info;
	static int[] result;
	static List<String> list;
	static boolean[] isSelected;
	static int N, mp, mf, ms, mv, min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());

		isSelected = new boolean[N];
		info = new int[N][5];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < 5; j++) {
				info[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		list = new ArrayList<>();

		int[] output = {};
		min = Integer.MAX_VALUE;

		for (int i = 1; i <= N; i++) {
			output = new int[i];
			dfs(0, 0, output, N, i, 0, 0, 0, 0, 0);
		}
		Collections.sort(list);
		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
			System.out.println(list.get(0));
		}

	}

	static void dfs(int at, int depth, int[] output, int n, int r, int mpSum, int mfSum, int msSum, int mvSum,
			int priceSum) {

		if (depth == r) {

			if (mpSum < mp || mfSum < mf || msSum < ms || mvSum < mv)
				return;
			if (min < priceSum)
				return;
			if (min > priceSum) {
				min = priceSum;
				list.clear();
			}

			String str = "";
			for (int i = 0; i < r; i++) {
				str += Integer.toString(output[i]) + " ";
			}
			list.add(str);
			return;
		}

		for (int i = at; i < N; i++) {
			isSelected[i] = true;
			output[depth] = i + 1;
			dfs(i + 1, depth + 1, output, n, r, mpSum + info[i][0], mfSum + info[i][1], msSum + info[i][2],
					mvSum + info[i][3], priceSum + info[i][4]);
			isSelected[i] = false;
		}

	}

	static void cal(int[] output) {

	}

}
//https://www.acmicpc.net/problem/19942