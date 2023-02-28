import java.util.Scanner;
import java.math.BigInteger;
public class Bronze10093 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();
		if(a==b) {
			System.out.println(0);
			System.exit(0);
		}
		else if(Math.abs(a-b)==1) {
			System.out.println(0);
			System.exit(0);
		}
		else if(a<b) {
			a++;
			System.out.println(b-a);
			while(true) {
				System.out.print(a + " ");
				a++;
				if(a==b) break;
			}
		}
		else if(a>b) {
			b++;
			System.out.println(a-b);
			while(true) {
				System.out.print(b + " ");
				b++;
				if(a==b) break;
			}
		}

	}

}
