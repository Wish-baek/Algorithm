import java.util.Scanner;
import java.math.BigInteger;
public class Bronze17256 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int ax = sc.nextInt();
		int ay = sc.nextInt();
		int az = sc.nextInt();

		int cx = sc.nextInt();
		int cy = sc.nextInt();
		int cz = sc.nextInt();
		int bx = cx-az;
		int by = cy/ay;
		int bz = cz-ax;
		
		System.out.println(bx + " " + by + " " + bz);
	
	}

}
