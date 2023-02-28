import java.util.Scanner;
import java.util.Arrays;
public class Bronze2490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for(int i = 0; i < 3; i++) {
			int sum = 0;
			
			for(int j = 0; j < 4; j++) {
			sum+=sc.nextInt();
			}
			
			if(sum==3) System.out.println("A");
			else if(sum==2) System.out.println("B");
			else if(sum==1) System.out.println("C");
			else if(sum==0) System.out.println("D");
			else if(sum==4) System.out.println("E");
		}
	}

}
