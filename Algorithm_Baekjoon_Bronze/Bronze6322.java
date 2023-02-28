import java.util.*;
public class Bronze6322 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = 1;
		while(true){
			
			double a = sc.nextDouble();
			double b = sc.nextDouble();
			double c = sc.nextDouble();
			
			if(a==0 && b==0 && c==0) break;
			System.out.println("Triangle " + "#" + n);
			if(a==-1) {
				double x = b*b+c*c;
				for(double i = 1; i < x; i++) {
					if(i*i==x) {
						System.out.println("a = " + i);
						break;
					}
					if(i==x-1) System.out.println("Impossible.");
				}
			}
			
			else if(b==-1) {
				double x = a*a+c*c;
				for(double i = 1; i < x; i++) {
					if(i*i==x) {
						System.out.println("b = " + i);
						break;
					}
					if(i==x-1) System.out.println("Impossible.");
				}
			}
			
			else if(c==-1) {
				double x = a*a+b*b;
				for(double i = 1; i < x; i++) {
					if(i*i==x) {
						System.out.println("c = " + i);
						break;
					}
					if(i==x-1) System.out.println("Impossible.");
				}
			}
			
			n++;
		}
		
	}

}
