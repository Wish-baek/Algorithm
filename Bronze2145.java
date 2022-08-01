import java.util.ArrayList;
import java.util.Scanner;

public class Bronze2145 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			
			int n = sc.nextInt();

			if(n==0) break;
		
			while(true) {
				ArrayList<Integer> arr = new ArrayList<>();

				int sum = 0;
				
				while(n>0) {
					arr.add(n%10);
					n/=10;
				}
				
				for(int i = 0; i < arr.size(); i++) {
					sum += arr.get(i);
				}
				n = sum;
				if(n<10) {
					System.out.println(n);
					break;
				}
				
			}
			
			
		}
		
	}

}
