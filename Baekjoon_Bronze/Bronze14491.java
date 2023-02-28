import java.util.*;

public class Bronze14491 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(n>0) {
			arr.add(n%9);
			n/=9;
			
		}
		
		for(int i = arr.size()-1; i >= 0; i--) {
			System.out.print(arr.get(i));
		}
		
	}

}
