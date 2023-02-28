import java.util.Scanner;

public class Bronze10995 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		for(int i = 1; i <= n; i++) {
			if(i%2==1) {
				System.out.print("*");
				for(int k = 0; k < n-1; k++) {
					System.out.print(" ");
					System.out.print("*");
				}
			}
			
			else if(i%2==0) {
				
				for(int k = 0; k < n; k++) {
					System.out.print(" ");
					System.out.print("*");
				}
			}
			System.out.println();
		}
		
	}

}
