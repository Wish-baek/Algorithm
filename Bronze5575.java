import java.util.Scanner;
import java.math.BigInteger;
public class Bronze5575 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int i;
		for(i=0; i<3; i++) {
		int ah = sc.nextInt();
		int am = sc.nextInt();
		int as = sc.nextInt();
		int bh = sc.nextInt();
		int bm = sc.nextInt();
		int bs = sc.nextInt();
		
		int s = (bs-as);
		int m = (bm-am);
		int h = (bh-ah);
		if(s<0) {
			s+=60;
			m--;
		}
		if(m<0) {
			m+=60;
			h--;
		}
		

		System.out.println(h + " " + m + " " + s);
		
		}
	}

}
