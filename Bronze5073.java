import java.util.*;

public class Bronze5073 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a==0 && b==0 && c==0) break;
			int[] arr = new int[3];
			arr[0] = a;
			arr[1] = b;
			arr[2] = c;
			
			Arrays.sort(arr);
			if(arr[0]+arr[1]<=arr[2]) System.out.println("Invalid");
			else if(a==b && b==c) System.out.println("Equilateral");
			else if(a==b || b==c || a==c) System.out.println("Isosceles");
			else System.out.println("Scalene");
		}
		
		
	}

}
