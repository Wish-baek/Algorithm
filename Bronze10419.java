import java.util.*;

public class Bronze10419 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		for(int i = 0; i < t; i++) {
			
			int a = sc.nextInt();
			int max = 0;
			for(int j = 1; j < a; j++) {
				if(j+j*j <= a && j+j*j > max) max = j; 
			}

			System.out.println(max);
		}
		
	}

}
