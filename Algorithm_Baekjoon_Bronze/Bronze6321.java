import java.util.Scanner;

public class Bronze6321 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int number = 1;
		for(int i = 0; i < n; i++) {
			System.out.println("String #" + number);
			char[] arr = sc.next().toCharArray();
			
			for(int j = 0; j < arr.length; j++) {
				if(arr[j]=='Z') arr[j] = 'A';
				else arr[j] = (char) (arr[j]+1);
				System.out.print(arr[j]);
			}
			System.out.println();
			System.out.println();
			number++;
		}
	}

}
