import java.util.*;
public class Bronze11721 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		char[] arr = sc.nextLine().toCharArray();

		for(int i=1; i<=arr.length; i++) {
			
			System.out.print(arr[i-1]);
			if(i%10==0) System.out.println();
			
		}
		
	}

}
