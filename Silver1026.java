import java.util.Arrays;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner7;

public class Silver1026 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int[] A = new int[n];
		for(int i = 0; i < n; i++) {
			A[i] = sc.nextInt();
		}
		
		int[] B = new int[n];
		for(int i = 0; i < n; i++) {
			B[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int sum = 0;
		
		for(int i = 0; i < n; i++) {
			sum+= A[i] * B[n-i-1];
		}
		System.out.println(sum);
	}

}
//https://www.acmicpc.net/problem/1026