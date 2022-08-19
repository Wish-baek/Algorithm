import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;

public class Bronze15792 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] str = br.readLine().split(" ");
		BigDecimal A = new BigDecimal(str[0]);
		BigDecimal B = new BigDecimal(str[1]);
		BigDecimal result = A.divide(B, 1000, BigDecimal.ROUND_HALF_UP);
		System.out.println(result);
	}

}
