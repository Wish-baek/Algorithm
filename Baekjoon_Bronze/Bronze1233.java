import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
public class Bronze1233 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
				
		int[] arr = new int[a*b*c];
		ArrayList<Integer> arr2 = new ArrayList<>();

		int pnt = 0;
		for(int i = 1; i <= a; i++) {
			for(int j = 1; j <=  b; j++) {
				for(int k = 1; k <=  c; k++) {
					int count=0;
					int sum = i+j+k;
					arr[pnt++]=sum;
					
				}
					
			}
		}
		Arrays.sort(arr);
		
		
		arr2.add(arr[0]);
		//System.out.println(max);
		
		int count = 0;
		int max = 0;
		int max_val = 0;
		for(int i = 1; i < arr.length; i++) {
			if( arr[i]==arr[i-1] ) {
				count++;
			}
			else count=1;
			if(count>max) {
				max = count;
				max_val = arr[i];
			}
		}
		System.out.println(max_val);
	}

}
