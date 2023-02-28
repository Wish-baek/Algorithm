import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Silver1018 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());

		String[][] arr = new String[N][M];

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split("");
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N - 8 + 1; i++) {

			for (int j = 0; j < M - 8 + 1; j++) {
				int cnt = 0;
				int cnt2 = 0;

				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (((i + k) % 2 == 0) && ((j + l) % 2 == 0) && arr[i + k][j + l].equals("W"))
							cnt++;
						else if (((i + k) % 2 == 0) && ((j + l) % 2 == 1) && arr[i + k][j + l].equals("B"))
							cnt++;
						else if (((i + k) % 2 == 1) && ((j + l) % 2 == 0) && arr[i + k][j + l].equals("B"))
							cnt++;
						else if (((i + k) % 2 == 1) && ((j + l) % 2 == 1) && arr[i + k][j + l].equals("W"))
							cnt++;
					}

				}
				for (int k = 0; k < 8; k++) {
					for (int l = 0; l < 8; l++) {
						if (((i + k) % 2 == 0) && ((j + l) % 2 == 0) && arr[i + k][j + l].equals("B"))
							cnt2++;
						else if (((i + k) % 2 == 0) && ((j + l) % 2 == 1) && arr[i + k][j + l].equals("W"))
							cnt2++;
						else if (((i + k) % 2 == 1) && ((j + l) % 2 == 0) && arr[i + k][j + l].equals("W"))
							cnt2++;
						else if (((i + k) % 2 == 1) && ((j + l) % 2 == 1) && arr[i + k][j + l].equals("B"))
							cnt2++;
					}

				}
				list.add(cnt);
				list.add(cnt2);
			}

		}
		Collections.sort(list);
		System.out.println(list.get(0));

	}

}
//https://www.acmicpc.net/problem/1018
