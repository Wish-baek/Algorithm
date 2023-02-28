import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Silver2161 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			arr.add(i);
		}

		while (true) {
			System.out.print(arr.get(0) + " ");
			
			arr.remove(0);
			if(arr.size()==0) break;
			arr.add(arr.get(0));
			arr.remove(0);
			
		}

	}

}
