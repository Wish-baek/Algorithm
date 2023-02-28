import java.util.Scanner;
import java.util.Arrays;
public class Bronze2863 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		double a = sc.nextDouble();
		double b = sc.nextDouble();
		double c = sc.nextDouble();
		double d = sc.nextDouble();

		double x = a/c+b/d;
		double y = c/d+a/b;
		double z = d/b+c/a;
		double q = b/a+d/c;
		
		double[] arr = {x, y, z, q};
		Arrays.sort(arr);
		if(Math.max(Math.max(x,  y), Math.max(z,  q))==x) System.out.println(0);
		else if(Math.max(Math.max(x,  y), Math.max(z,  q))==y) System.out.println(1);
		else if(Math.max(Math.max(x,  y), Math.max(z,  q))==z) System.out.println(2);
		else if(Math.max(Math.max(x,  y), Math.max(z,  q))==q) System.out.println(3);
		
	
	
	}

}
