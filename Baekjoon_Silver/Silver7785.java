import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Silver7785 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Map<String, String> map = new HashMap<>();
		
		int n = sc.nextInt();
		
		for(int i = 0; i < n; i++) {
			String name = sc.next();
			String status = sc.next();
			
			map.put(name, status);
			
		}
		
		List<String> result = new ArrayList<>();
		for(String str : map.keySet()) {
			if(map.get(str).equals("enter")) {
				result.add(str);
			}
		}
		Collections.sort(result, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o2.compareTo(o1);
			}
		});
		
		for(String st : result) {
			System.out.println(st);
		}
		
	}

}
