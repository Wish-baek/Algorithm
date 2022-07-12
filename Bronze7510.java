import java.util.*;
import java.math.BigInteger;
public class Bronze7510 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		BigInteger[] arr = new BigInteger[3];
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Scenario #" + i + ":");
			arr[0] = sc.nextBigInteger();
			arr[1] = sc.nextBigInteger();
			arr[2] = sc.nextBigInteger();
			Arrays.sort(arr);
			BigInteger a = arr[0].multiply(arr[0]);
			BigInteger b = arr[1].multiply(arr[1]);
			BigInteger c = arr[2].multiply(arr[2]);
			
			if(a.add(b).compareTo(c)==0) {
				System.out.println("yes");
			}
			else System.out.println("no");
			System.out.println();
		}
	}

}
