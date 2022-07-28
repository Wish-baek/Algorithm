import java.util.Scanner;

public class Bronze1672 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if (n==1) {
			String a = sc.next();
			System.out.println(a);
			System.exit(0);
		}
		char[][] arr = { {'A', 'C', 'A', 'G'},
					     {'C', 'G', 'T', 'A'},	
						 {'A', 'T', 'C', 'G'},
						 {'G', 'A', 'G', 'T'} };
		char[] arr2 = {'A', 'G', 'C', 'T'};

		char[] tmp = sc.next().toCharArray();
		char[] dna = new char[n];
		
		for(int i = 0; i < n; i++) {
			dna[i] = tmp[n-i-1];
		}

		int x = 0;
		int y = 0;
		
		for(int i = 0; i < arr2.length; i++) {
			if(dna[0]==(arr2[i])) x=i;
			if(dna[1]==(arr2[i])) y=i;
		}
		char str=arr[x][y];

		int cnt = 2;
		while(cnt<dna.length) {
			for(int i = 0; i < arr2.length; i++) {
				if(str==arr2[i]) x=i;
				if(dna[cnt]==arr2[i]) y=i;
			}
			
			str=arr[x][y];
	

			cnt++;
			
		}
		System.out.println(str);
		
		
	}

}
