import java.util.Scanner;

public class Bronze1362 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int cnt = 1;
		
		while(true) {
			int o = sc.nextInt();
			int w = sc.nextInt();
			if(o==0 && w==0) break;
			int currentw = w;
			int death=0;
			while(true) {
				String a = sc.next();
				int n = sc.nextInt();
				
				if( a.equals("#") && n==0)	break;
				
				else if( a.equals("F") ) currentw+=n;
				else if( a.equals("E") ) currentw-=n;
				
				if(currentw<=0) {
					death++;				
				}
				
				
			}
			if(death>0) System.out.println(cnt + " RIP");
			else if(currentw>o/2 && currentw<2*o) System.out.println(cnt + " :-)");
			else System.out.println(cnt + " :-(");
			
			cnt++;
		}
		
	}

}
