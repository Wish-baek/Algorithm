import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Silver2164 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		
		if(n==1) {
			System.out.println(1);
			System.exit(0);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			q.add(i);
		}
		while(true) {
			q.remove();
			if(q.size()==1) break;
			q.add(q.peek());
			
			q.remove();
		
		}
		System.out.println(q.peek());
		
	}

}
