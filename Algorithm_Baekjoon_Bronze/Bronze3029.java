import java.util.Arrays;
import java.util.Scanner;

public class Bronze3029 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String[] arr = sc.next().split(":");
		String[] arr2 = sc.next().split(":");
		int[] a = new int[3];
		int[] b = new int[3];
		for(int i = 0; i < 3; i++) {
			a[i] = Integer.parseInt(arr[i]);
			b[i] = Integer.parseInt(arr2[i]);
		}
		
		if(b[2]<a[2]) {
			b[2]+=60;
			b[1]-=1;
		}
		int s = b[2]-a[2];
		if(b[1]<a[1]) {
			b[1]+=60;
			b[0]-=1;
		}
		int m = b[1]-a[1];
		if(b[0]<a[0]) {
			b[0]+=24;
		}
		int h = b[0]-a[0];
		if(h==0 && m==0 && s==0) System.out.println("24:0:0");
		else System.out.printf("%02d:%02d:%02d", h, m, s);
	}

}
