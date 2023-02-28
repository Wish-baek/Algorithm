import java.util.*;
public class Bronze13223 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] a = sc.next().split(":");
		String[] b = sc.next().split(":");
		
		int h = Integer.parseInt(b[0])-Integer.parseInt(a[0]);
		int m = Integer.parseInt(b[1])-Integer.parseInt(a[1]);
		int s = Integer.parseInt(b[2])-Integer.parseInt(a[2]);
		
		if(s<0) {
			s+=60;
			m--;
		}
		if(m<0) {
			m+=60;
			h--;
		}
		if(h<0) h+=24;
		if(h==0 & m==0 & s==0) h=24;
		
		System.out.printf("%02d:%02d:%02d", h, m, s);
		
		
	}

}
