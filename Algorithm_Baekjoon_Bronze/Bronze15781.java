import java.util.Scanner;
import java.math.*;

public class Bronze15781 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int amax = 0;
		int bmax = 0;
		
		for(int i=0; i<a; i++) {
			int x = sc.nextInt();
			if(x>amax) amax = x;
		}
		for(int i=0; i<b; i++) {
			int y = sc.nextInt();
			if(y>bmax) bmax = y;
		}
		System.out.println(amax+bmax);
	}

}
