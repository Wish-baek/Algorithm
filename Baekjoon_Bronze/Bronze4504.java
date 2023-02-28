import java.util.*;
import java.util.Scanner;

public class Bronze4504 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		while(true) {
			int a = sc.nextInt();
			if(a==0) break;
			if(a%3==0) System.out.printf("%d is a multiple of %d.\n",a, n);
			else System.out.printf("%d is NOT a multiple of %d.\n",a, n);
			
		}
	}

}
