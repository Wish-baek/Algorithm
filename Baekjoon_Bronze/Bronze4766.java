import java.util.*;
import java.util.Scanner;

public class Bronze4766 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<Double> arr = new ArrayList<>();
		
		while(true) {
			double a = sc.nextDouble();
			if(a==999) break;
			arr.add(a);
		
		}
		
		for(int i = 0; i < arr.size()-1; i++) {
			System.out.printf("%.2f\n", arr.get(i+1)-arr.get(i));
		}
		
	}

}
