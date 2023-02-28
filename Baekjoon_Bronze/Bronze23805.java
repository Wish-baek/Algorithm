import java.util.Scanner;
public class Bronze23805 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		for(int i = 0; i < n ; i++) {
			
			for(int l = 0; l < n*3; l++) {
				System.out.print("@");
			}
			
			
			
			for(int k = 0; k < n; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j < n; j++) {
				System.out.print("@");
			}
			System.out.println();
		}
		
		for(int i = 0; i < 3*n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("@");
			}
			
			for(int l = 0; l < 2; l++) {
				for(int k = 0; k < n; k++) {
					System.out.print(" ");
				}
				for(int k = 0; k < n; k++) {
					System.out.print("@");
				}
			}
			System.out.println();
		}
		
		for(int i = 0; i < n ; i++) {
			
			for(int j = 0; j < n; j++) {
				System.out.print("@");
			}
			for(int k = 0; k < n; k++) {
				System.out.print(" ");
			}
			for(int l = 0; l < n*3; l++) {
				System.out.print("@");
			}
			System.out.println();
			
		}
		
		
		
		
	}

}
