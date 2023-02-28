import java.util.*;
public class Bronze1247 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		int i, j;
		for(i = 0; i < 3; i++) {
			int N = sc.nextInt();
			long sum = 0;
			
			for(j = 0; j < N; j++) {
				sum+=sc.nextLong();
			}
			
			if(sum==0) System.out.println(0);
			else if(sum>0) System.out.println("+");
			else if(sum<0) System.out.println("-");
			
		}
		

	}

}
