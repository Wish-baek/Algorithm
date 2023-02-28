import java.util.Scanner;

public class Bronze1408 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String a = sc.next();
		String b = sc.next();
		
		int ch = Integer.parseInt(a.split(":")[0]);
		int cm = Integer.parseInt(a.split(":")[1]);
		int cs = Integer.parseInt(a.split(":")[2]);
		
		int sh = Integer.parseInt(b.split(":")[0]);
		int sm = Integer.parseInt(b.split(":")[1]);
		int ss = Integer.parseInt(b.split(":")[2]);
		
		int s = ss-cs;
		if(s<0) {
			s+=60;
			sm--;
		}
		int m = sm-cm;
		if(m<0) {
			m+=60;
			sh--;
		}
		int h = sh-ch;
		if(h<0) h+=24;

		System.out.printf( "%02d:%02d:%02d", h, m, s );
	}

}
