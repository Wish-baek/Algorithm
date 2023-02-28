import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Silver10867 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			if (!arr.contains(num))
				arr.add(num);
		}

		Collections.sort(arr);

		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
	}

}
