import java.util.Arrays;
import java.util.Scanner;

public class Bronze3985 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();

		int[][] arr = new int[N][2];

		int[] cake = new int[L];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		int max = -1;
		int index = -1;
		for (int i = 0; i < N; i++) {
			if (arr[i][1] - arr[i][0] > max) {
				max = arr[i][1] - arr[i][0];
				index = i;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = arr[i][0] - 1; j < arr[i][1]; j++) {
				if (cake[j] == 0) {
					cake[j] = i + 1;
				}
			}
		}

		int[] getcake = new int[N];
		
		for (int i = 0; i < cake.length; i++) {
			if(cake[i]==0) continue;
			getcake[cake[i]-1]++;
		}
		
		int maxcake = -1;
		int idx = -1;
		for (int i = 0; i < getcake.length; i++) {
			if(getcake[i]>maxcake) {
				maxcake = getcake[i];
				idx = i;
			}
		}
		
		System.out.println(index+1);
		System.out.println(idx+1);

	}
}