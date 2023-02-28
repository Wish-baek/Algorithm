import java.util.Scanner;

public class Bronze2028 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++) {
			
			int n = sc.nextInt();
			String[] arr = Integer.toString(n).split("");
			
			int jegob = n*n;
			String[] arr2 = Integer.toString(jegob).split("");
			
			int tmp = arr2.length-1;
			int cnt = 0;

			for(int j = arr.length-1; j>=0; j--) {
				if(arr[j].equals(arr2[tmp])) {
					cnt++;
					tmp--;
					
				}
				else break;
			}
				
			if (cnt==arr.length) System.out.println("YES");
			else System.out.println("NO");
			
		}
		
	}

}
