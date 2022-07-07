import java.util.Arrays;
import java.util.Scanner;

public class Bronze3034 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int x = w*w + h*h;
		for(int i = 0; i < n; i++) {
			int a =  sc.nextInt();
			if(a*a <= x) System.out.println("DA");
			else System.out.println("NE");
		}
		
	}

}
