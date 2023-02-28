
public class Silver4673 {
	public static void self() {
		for(int x = 1; x <= 10000; x++) {
			int count = 0;
		
			for(int y = 1; y <= x; y++) {
				int sum=0;
				int tmp = y;
				while(tmp>0) {
					sum+=tmp%10;
					tmp/=10;
				}
				if( y + sum == x)	{
					
					count++;
				}
			}
		
			if(count==0) System.out.println(x);
		}
	}
    	
	public static void main(String[] args) {
		self();
	}

}
