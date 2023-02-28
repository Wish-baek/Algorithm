import java.util.Scanner;

public class Silver1244 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		
		int[] arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		int st = sc.nextInt();
		
		for(int i = 0 ; i < st; i++) {
			int s = sc.nextInt();
			int num = sc.nextInt();
	
			if(s==1) {
				for(int j = 0; j < arr.length; j++) {
					if((j+1)%num==0) {
						if(arr[j]==0) arr[j] = 1;
						else if(arr[j]==1) arr[j] = 0;
					}
				}
			}
			
			else if(s==2) {
				int max = 0;
				int index = 0;
				int count = 0;

				int tmp = Math.min(num-1, arr.length-num);
					
				for(int h = 1; h <=tmp; h++) {
					if(arr[num-1-h]==arr[num-1+h]) count++;
					else break;
				}
				
				for(int l = 1; l <= count; l++) {
					if(arr[num-1-l]==0) {
						arr[num-1-l]=1;
						arr[num-1+l]=1;
					}
					else if(arr[num-1-l]==1) {
						arr[num-1-l]=0;
						arr[num-1+l]=0;
					}
					

				}
				if (arr[num-1]==0) arr[num-1]=1;
				else if (arr[num-1]==1) arr[num-1]=0;
				
			}		
			
		}
		int cnt = 0;
		for(int p = 0; p < arr.length; p++) {
			System.out.print(arr[p] + " ");
			cnt++;
			if(cnt==20) {
				System.out.println();
				cnt=0;
			}
		}
	}

}
