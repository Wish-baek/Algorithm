import java.util.Scanner;
public class Bronze2443 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		for(int i = 2*n-1; i >= 1; i-=2) {
			
			for(int a = 0; a < ((2*n-1)-i)/2; a++) {
				System.out.print(" ");
			}
			for(int b = 1; b <= i; b++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
