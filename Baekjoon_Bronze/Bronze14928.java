import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Bronze14928 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
        long remain = 0;
        for(int i =0; i < N.length(); i++){
            remain = (remain * 10 + (N.charAt(i) - '0')) % 20000303;
        }
       System.out.println(remain);
	}

}
//https://www.acmicpc.net/problem/14928