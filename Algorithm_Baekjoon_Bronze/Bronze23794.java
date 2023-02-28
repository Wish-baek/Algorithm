import java.util.*;
public class Bronze23794 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n+2; i++) {
			System.out.print("@");
		}
		System.out.println();
		for(int i = 0; i < n; i++) {
			System.out.print("@");
			for(int j = 0; j < n; j++) {
				System.out.print(" ");
			}
			
			System.out.print("@");
			System.out.println();
		}
		for(int i = 0; i < n+2; i++) {
			System.out.print("@");
		}
		
	}

}
