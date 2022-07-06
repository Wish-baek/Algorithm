import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.math.BigInteger;
public class Bronze2997 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		Arrays.sort(arr);
		int a = arr[2]-arr[1];
		int b = arr[1]-arr[0];
		if(a==b) System.out.println(arr[2]+a);
		else if(Math.min(a,  b)==a) System.out.println(arr[0]+a);
		else if(Math.min(a,  b)==b) System.out.println(arr[2]-b);
		
		
	}

}
