import java.util.Scanner;
public class Bronze23803 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < 4*n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print("@");
			}
			System.out.println();
		}
		for(int i = 0; i < n ; i++) {
			for(int j = 0; j <5*n; j++) {
				System.out.print("@");
			}
			System.out.println();
		}
		
		
		
		
	}

}
