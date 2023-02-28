import java.util.Scanner;

public class Bronze2765 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 1;
		while(true) {
			
			
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble()/3600;
			if(b==0) break;
			
			double mile = a/63360*Math.PI*b;
			
			System.out.printf("Trip #%d: %.2f %.2f", n, mile, mile/c);
			System.out.println();
			n++;
		}
	}

}
