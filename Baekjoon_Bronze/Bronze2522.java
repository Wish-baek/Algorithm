import java.util.Scanner;
public class Bronze2522 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < n-i; j++) {
				System.out.print(" ");
			}
			for(int k = 0; k < i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		for(int i = 1; i <= n; i++) {
			for(int k = 0; k < i; k++) {
				System.out.print(" ");
			}
			for(int j = 0; j < n-i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
	}

}
