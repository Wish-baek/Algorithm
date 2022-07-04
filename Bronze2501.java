import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Bronze2501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int k = sc.nextInt();
		
		int count=0;
		for(int i = 1; i <= a; i++) {
			if(a%i==0) count++;
		}
		
		int[] arr = new int[count];
		int p = 0;
		for(int i = 1; i <= a; i++) {
			if(a%i==0) {
				arr[p] = i;
				p++;
			}
		}
		System.out.println(arr[k-1]);
	}
		
}


