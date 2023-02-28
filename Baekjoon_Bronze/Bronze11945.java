import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Bronze11945{
    public static void main(String args[]) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
        String r = bf.readLine();
        String[] rr = r.split(" ");
        int a = Integer.parseInt(rr[0]);
        int b = Integer.parseInt(rr[1]);
        
        for(int i = 0; i < a; i++) {
        	String arr = bf.readLine();
        	for(int j = b-1; j >= 0; j--) {
        		System.out.print(arr.charAt(j));
        	}
        	System.out.println("");
        	
        }
        
    }
}