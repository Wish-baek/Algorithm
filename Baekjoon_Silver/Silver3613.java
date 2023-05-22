import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Silver3613 {

    // 예외상황?
    // - 가장 첫 글자가 대문자인 경우
    // - 언더바와 대문자가 함께 포함되어있는 경우

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        String str = br.readLine();


        String type = "nothing";
        if (str.contains("_"))
            type = "cpp";
    if ((65 <= str.charAt(0) && str.charAt(0) <= 90) || str.charAt(0) == '_') {
            System.out.println("Error!");
            System.exit(0);
        }

        String result = "";

        boolean isUpper = false;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (65 <= ch && ch <= 90) { // 대문자라면
                if (type.equals("cpp")) {
                    result = "Error!";
                    break;
                } else {
                    result += "_";
                    result += (char) (ch + 32);
                }
            } else if (97 <= ch && ch <= 122) { // 소문자라면
                if (isUpper) {
                    result += (char) (ch - 32);
                    isUpper = false;
                } else
                    result += ch;
            } else if (ch == '_') {

                if (isUpper || i == str.length() - 1) {
                    result = "Error!";
                    break;
                } else if (type.equals("java")) {
                    result = "Error!";
                    break;
                } else
                    isUpper = true;
            }
        }

        System.out.println(result);
    }
}
//https://www.acmicpc.net/problem/3613