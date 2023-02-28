import java.util.*;
public class Bronze3460 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			
			int n = sc.nextInt();
			int k = 0;
			while(n> 0) {
				int p = n%2;
				n/=2;
				if (p==1) System.out.println(k);
				k++;
			}
			
			
		}
		
	}

}
