import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver2941 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String[] sarr = str.split("");
		
		int cnt = 0;
		int tmp = 0;
		String[] arr = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		for(int i = 0; i < sarr.length; i++) {
			if(sarr[i].equals("d")) {
				if(i+1<sarr.length && sarr[i+1].equals("z")) {
					if(i+2<sarr.length && sarr[i+2].equals("=")) {
						cnt++;
						tmp+=3;
						i+=2;
					}
					
				}
	
				else if(i+1<sarr.length && sarr[i+1].equals("-")){
					cnt++;
					tmp+=2;
				}
			}
			if(sarr[i].equals("c")) {
				if(i+1<sarr.length && sarr[i+1].equals("=")) {
					cnt++;
					tmp+=2;
				}
				else if(i+1<sarr.length && sarr[i+1].equals("-")) {
					cnt++;
					tmp+=2;
				}
			}
			
			
			
			if(sarr[i].equals("l") && i+1<sarr.length && sarr[i+1].equals("j")) {
				cnt++;
				tmp+=2;
			}
			if(sarr[i].equals("n") && i+1<sarr.length && sarr[i+1].equals("j")) {
				cnt++;
				tmp+=2;
			}
			if(sarr[i].equals("s") && i+1<sarr.length && sarr[i+1].equals("=")) {
				cnt++;
				tmp+=2;
			}
			if(sarr[i].equals("z") && i+1<sarr.length && sarr[i+1].equals("=")) {
				cnt++;
				tmp+=2;
			}
		}
		
		System.out.println(cnt + str.length()-tmp);
	}

}
//https://www.acmicpc.net/problem/2941
