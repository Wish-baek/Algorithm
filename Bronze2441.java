import java.util.Scanner;
public class Bronze2441 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = 0;
		int y = n;
		for(int i = 0; i < n; i++) {
			
			for(int a = 0; a < x; a++) {
				System.out.print(" ");
			}
			for(int b = y; b >= 1; b--) {
				System.out.print("*");
			}
			x++;
			y--;
			System.out.println();
		}
	}

}
