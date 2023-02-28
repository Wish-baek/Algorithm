import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Bronze2775 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[15][15];
		int k = sc.nextInt();
		for (int t = 0; t < k; t++) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			int n = 1;
			for(int i = 0; i < 15; i++) {
				arr[0][i] = n++;
				arr[i][0] = 1;
			}

			for(int i = 1; i < 15; i++) {
				for (int j = 1; j < 15; j++) {
					arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
				}
			}
			System.out.println(arr[a][b-1]);
		}
	}
}
//https://www.acmicpc.net/problem/2775