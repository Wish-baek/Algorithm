import java.util.Scanner;
import java.util.Arrays;
public class Bronze2576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int sum = 0;
		int p = 0;
		int[] arr = new int[7];
		for(int i = 0; i < 7; i++) {
			int x = sc.nextInt();
			if(x%2==1) {
				arr[i] = x;
				sum+=x;
			}
			else arr[i] = 100;
		}
		Arrays.sort(arr);
		if(sum==0)System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(arr[0]);
		}
		
	}

}
