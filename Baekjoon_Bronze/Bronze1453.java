import java.util.Scanner;

public class Bronze1453 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[100];
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int w = sc.nextInt();
			
			if(arr[w-1]==0) arr[w-1]=1;
			else if(arr[w-1]!=0) count++;
			
		}
		System.out.println(count);
	}

}
