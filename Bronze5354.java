import java.util.*;
import java.util.Scanner;

public class Bronze5354 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			int n = sc.nextInt();
			if(n==1) System.out.println("#");
			else {for(int j = 0; j < n; j++) {
				System.out.print("#");
			}
			System.out.println();
			for(int k = 0; k < n-2; k++) {
				

				System.out.print("#");
				for(int p = 0; p < n-2; p++) {
					System.out.print("J");
				}
				
				System.out.print("#");
				System.out.println();
				
			}
			
			for(int j = 0; j < n; j++) {
				System.out.print("#");
			}
			if (i==t-1) break;
			System.out.println();
			System.out.println();
			}
		}
		
	}
}