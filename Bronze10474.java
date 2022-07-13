import java.util.*;
public class Bronze10474 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if(a==0 && b==0) break;
			
			System.out.printf( "%d %d / %d", a/b, a%b, b );
			System.out.println();
		}
		
	}

}
