import java.util.Scanner;
import java.util.Arrays;
import java.math.BigInteger;
public class Bronze2752 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[3];
		int i;
		for(i=0; i<3; i++) {
			arr[i]=sc.nextInt();
		}
		Arrays.sort(arr);
		for(i=0; i<3; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
