import java.util.*;

public class Bronze1076 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String[] color = {"black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white"};
		int[] value = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] mul = new int[10];
		
		String result = "";
	
		String a = sc.next();
		
		for(int i = 0; i < 10;  i++) {
			if(a.equals(color[i])) result+=Long.toString(value[i]);
		}
		String b = sc.next();
		
		for(int i = 0; i < 10;  i++) {
			if(b.equals(color[i])) result+=Long.toString(value[i]);
		}
		
		String c = sc.next();
		for(int i = 0; i < 10;  i++) {
			if(c.equals(color[i])) result=Long.toString((int)Math.pow(10, i) * Long.parseLong(result));
		}
		
		System.out.println(result);
	}

}
