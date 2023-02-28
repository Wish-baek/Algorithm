import java.util.*;
import java.math.BigInteger;
public class Bronze1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		long sum = 0;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				sum+=Character.getNumericValue(a[i])*Character.getNumericValue(b[j]);
			}
		}
		
		
		System.out.println(sum);
	}
	

}
