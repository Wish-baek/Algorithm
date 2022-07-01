import java.util.*;
import java.util.Arrays;
public class Bronze1085 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int[] arr = new int[4];
		arr[0] = x;
		arr[1] = h-y;
		arr[2] = w-x;
		arr[3] = y;
		
		Arrays.sort(arr);
		System.out.println(arr[0]);
		
	}

}
