import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;
public class Bronze3009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] x = new int[3];
		int[] y = new int[3];
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < 3; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		if(x[0]==x[1]) a = x[2];
		else if(x[1]==x[2]) a = x[0];
		else if(x[2]==x[0]) a =x[1];
		
		if(y[0]==y[1]) b = y[2];
		else if(y[1]==y[2]) b = y[0];
		else if(y[2]==y[0]) b =y[1];
		
		System.out.println(a + " " + b);
	}

}
