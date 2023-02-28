import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Bronze2953 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int[] arr = new int[5];
		int max = 0;
		int n = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i]+=sc.nextInt();
			}
			if(arr[i]>max) {
				max = arr[i];
				n = i;
			}
		}
		System.out.println((n+1) + " " + max);
	}

}
