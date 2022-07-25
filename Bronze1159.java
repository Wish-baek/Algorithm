import java.util.*;

public class Bronze1159 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String[] arr = new String[n];
		for(int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		
		Arrays.sort(arr);
		if( n< 5) {
			System.out.println("PREDAJA");
			System.exit(0);
		}
		if(n>=5 && arr[0].charAt(0)==arr[arr.length-1].charAt(0)) {
			System.out.println(arr[0].charAt(0));
			System.exit(0);
		}
		
		int count = 1;
		int result = 0;
		for(int i = 1; i < arr.length; i++) {
			
			if( arr[i].charAt(0)==arr[i-1].charAt(0)) {
				count++;
			}
			else count=1;
			
			if(count==5) {
				System.out.print(arr[i].charAt(0));
				result++;
			}
		}
		if(result==0) System.out.println("PREDAJA");
		
	}

}
