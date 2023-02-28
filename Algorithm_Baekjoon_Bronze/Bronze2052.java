import java.util.Scanner;
import java.math.BigDecimal;
public class Bronze2052 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		BigDecimal result = new BigDecimal(1.0);
		for(int i = 0; i < n; i++) {
			result = result.divide(BigDecimal.valueOf(2));
		}
		System.out.println(result.toPlainString());
	}

}
