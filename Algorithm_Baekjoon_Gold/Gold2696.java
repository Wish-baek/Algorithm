import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Gold2696 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
//		int T = Integer.parseInt(br.readLine());
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {

//			int N = Integer.parseInt(br.readLine());
			int N = sc.nextInt();
			int[] arr = new int[N];
//			st = new StringTokenizer(br.readLine(), " ");

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			List<Integer> list = new ArrayList<>();

			int cnt = 0;

			if (N % 2 == 0)
				sb.append(N / 2).append("\n");
			else
				sb.append(N / 2 + 1).append("\n");

			for (int i = 0; i < N; i++) {
				
				list.add(arr[i]);
				if (i % 2 == 0) {

					Collections.sort(list);
					if (cnt ==9 || i == N - 1) {
                        sb.append(list.get(list.size() / 2) + "\n");
                        cnt = 0;
                    } else {
                        sb.append(list.get(list.size() / 2) + " ");
                    }
                    cnt++;
                }
			}

		}
		System.out.print(sb);
	}

}
//https://www.acmicpc.net/problem/2696