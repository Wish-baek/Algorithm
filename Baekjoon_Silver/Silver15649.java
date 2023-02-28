import java.util.Arrays;
import java.util.Scanner;

public class Silver15649 {
	static int N, R, totalCnt;
	static int[] numbers;
	static boolean[] isSelected;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		totalCnt = 0;
		
		numbers = new int[R];
		
		isSelected = new boolean[N + 1]; 
	
		perm(0);
	}
	public static void perm(int cnt) { 

		if(cnt==R) {
			totalCnt++;
			for(int i = 0; i < numbers.length; i++) {
				System.out.print(numbers[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if (isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			perm(cnt + 1);
			isSelected[i] = false;
		}

	}
}
//https://www.acmicpc.net/problem/15649