import java.util.Scanner;
public class Bronze3058 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int sum = 0;
			int min = 0;
			int[] arr = new int[7];
			
			for(int j = 0; j < 7; j++) {
				int k = sc.nextInt();
				arr[j] = k;
				if(k%2==0) min = k;
			}
			for(int p = 0; p < 7; p++) {
				if(arr[p]%2==0) {
					sum+=arr[p];
				}
				if(arr[p]%2==0 && arr[p]<min) min = arr[p];
			}
			
			
			
			System.out.println(sum+ " " +min);
			
		}
		
	}

}
