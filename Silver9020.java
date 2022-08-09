import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver9020 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[123456 * 2 + 1];
		for (int i = 2; i <= arr.length - 1; i++) {
			arr[i] = i;
		}
		for (int i = 2; i < arr.length; i++) {
			if (arr[i] == 0)
				continue;

			for (int j = 2 * i; j <= arr.length; j += i) {
				arr[j] = 0;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			int min = 10000;
			int A = 0;
			int B = 0;
			int num = Integer.parseInt(br.readLine());
			for(int a = 1; a < num; a++) {
				if(arr[a]!=0 && arr[num-a]!=0) {
					if(Math.abs(a-(num-a))<min) {
						min = Math.abs(a-(num-a));
						A = a;
						B = num-a;
					}
				}
			}
			System.out.println(Math.min(A, B) + " " + Math.max(A,  B));
		}
		
	}

}
//https://www.acmicpc.net/problem/9020