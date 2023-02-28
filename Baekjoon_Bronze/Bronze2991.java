import java.util.Scanner;
import java.util.ArrayList;
import java.math.BigInteger;
public class Bronze2991 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		
		int[] arr = new int[3];
		arr[0] = sc.nextInt();
		arr[1] = sc.nextInt();
		arr[2] = sc.nextInt();
		
		for(int i = 0; i < A; i++) {
			a.add(1);
		}
		for(int i = 0; i < B; i++) {
			a.add(0);
		}
		for(int i = 0; i < C; i++) {
			b.add(1);
		}
		for(int i = 0; i < D; i++) {
			b.add(0);
		}
		for(int i = 0; i < 3; i++) {
			int q = arr[i]%(A+B);
			if(q==0) q = A+B;
			int w = arr[i]%(C+D);
			if(w==0) w = A+B;
			
			if(a.get(q-1)==1 && b.get(w-1)==1) System.out.println(2);
			else if(a.get(q-1)==1 && b.get(w-1)==0) System.out.println(1);
			else if(a.get(q-1)==0 && b.get(w-1)==1) System.out.println(1);
			else System.out.println(0);
		}
		
	}

}
