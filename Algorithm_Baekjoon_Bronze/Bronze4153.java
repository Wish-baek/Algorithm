import java.util.*;
public class Bronze4153 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int[] arr = new int[3];
			
			arr[0] = sc.nextInt();
			arr[1] = sc.nextInt();
			arr[2] = sc.nextInt();
			if(arr[0]==0 && arr[1]==0 && arr[2]==0) break;
			Arrays.sort(arr);
			if(arr[2]*arr[2] == arr[0]*arr[0] + arr[1]*arr[1]) System.out.println("right");
			else System.out.println("wrong");
			
		}
		
	}

}
