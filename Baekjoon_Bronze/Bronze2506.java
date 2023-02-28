import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Bronze2506 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int count = 0;
		for(int j = 0; j < n; j++) {
			if(arr[j]==1) count++;
			else if(arr[j]==0) count=0;
			
			sum+=count;
			
		}
		System.out.println(sum);
		
	}
		
}


