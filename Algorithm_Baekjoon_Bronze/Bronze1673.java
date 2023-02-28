import java.util.Scanner;

public class Bronze1673 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while(sc.hasNext()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int stamp = 0;
			int coupon = n;
			int chicken = 0;
			
			while( true ) { 
				
				if(stamp>=k) {
					
					int a = stamp / k;
					coupon+=a;
					stamp = stamp%k;
				
				}	
				if(coupon>0) {
					chicken+=coupon;
					stamp+=coupon;
					coupon=0;
				}
				
				
				if(stamp<k && coupon==0) break;
				
			}
			System.out.println(chicken);
		}
		
	}

}
