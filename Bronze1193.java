import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bronze1193 {
	static int x = 0;
	static int y = 0;
	
	public static void row(int n) {
		int row = 1;
		int tmp = -1;
		int number = 1;
		
		while(true) {
			int index = 1;
			for(int i = 1; i <= row; i++) {
				//System.out.print(number);

				if(number==n) {
					x = row;
					y = index;
					return;
				}

				number++;
				index++;
			}
			
			row++;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		row(n);
		if(x%2==1) {
			
			System.out.println(x+1-y + "/" + y);
			
		}
		else System.out.println(y + "/" + (x+1-y));
	}

}
//https://www.acmicpc.net/problem/1193
