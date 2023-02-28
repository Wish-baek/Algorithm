import java.util.Scanner;
public class Bronze2445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for(int i = 2*n-3; i >= 1; i-=2) {
			
			for(int a = 0; a < ((2*n-1)-i)/2; a++) {
				System.out.print("*");
			}
			for(int b = 0; b <= i; b++) {
				System.out.print(" ");
			}
			for(int a = 0; a < ((2*n-1)-i)/2; a++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for(int i = 1; i <= 2*n; i++) {
			System.out.print("*");
		}
		
		System.out.println();
		
		for(int i = 1; i <= 2*n-3; i+=2) {
			
			for(int a = 0; a < ((2*n-1)-i)/2; a++) {
				System.out.print("*");
			}
			for(int b = 0; b <=i; b++) {
				System.out.print(" ");
			}
			for(int a = 0; a < ((2*n-1)-i)/2; a++) {
				System.out.print("*");
			}
			System.out.println();
			
		}
		
		
	}

}
