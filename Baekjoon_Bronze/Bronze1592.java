import java.util.Scanner;

public class Bronze1592 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt(); // 사람 수
		int M = sc.nextInt(); // 한 사람이 공을 M번 받으면 끝남
		int L = sc.nextInt(); // 공 던질 위치

		int[] arr = new int[N];
		int start = 0;
		int cnt = 0;

		while (true) {

			if (arr[start] % 2 == 1) {
				start = (start + L) % N;
				arr[start]++;
				cnt++;
			} else {
				start -= L;
				if (start < 0) {
					while (start < 0) {
						start += N;
					}
				}
				arr[start]++;
				cnt++;
			}
			
			if (arr[start] == M)
				break;

		}
		System.out.println(cnt-1);
	}

}
//https://www.acmicpc.net/problem/1592
