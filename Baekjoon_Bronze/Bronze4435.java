import java.util.Scanner;

public class Bronze4435 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] gscore = {1, 2, 3, 3, 4, 10};
		int[] sscore = {1, 2, 2, 2, 3, 5, 10};
		
		int T = sc.nextInt();
		
		for(int p = 1; p <= T; p++) {
			int gsum = 0;
			int ssum = 0;
			
			for(int i = 0; i < 6; i++) {
				gsum += sc.nextInt()*gscore[i];
			}
			
			for(int i = 0; i < 7; i++) {
				ssum += sc.nextInt()*sscore[i];
			}
			
			if(gsum>ssum) System.out.println("Battle " + p + ": " + "Good triumphs over Evil");
			else if(ssum>gsum) System.out.println("Battle " + p + ": " + "Evil eradicates all trace of Good");
			else System.out.println("Battle " + p + ": " + "No victor on this battle field");
		}
		
		
		
		
	}

}
