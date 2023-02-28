import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver11729 {

	
	public static StringBuilder sb = new StringBuilder();

	
	public static void hanoi(int from, int tmp, int to, int other) {
		if(other==0) return;
		hanoi(from, to, tmp, other-1);
		sb.append(from + " " + to + "\n");
		hanoi(tmp, from, to, other-1);
		
	}
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		System.out.println((int)Math.pow(2, n)-1);
		hanoi(1, 2, 3, n);
		System.out.println(sb);
	}

}
//https://www.acmicpc.net/problem/11729