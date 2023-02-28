import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.ListIterator;

public class Silver1406 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String str = br.readLine();

		int n = Integer.parseInt(br.readLine());

		LinkedList<Character> list = new LinkedList<>();

		for (int i = 0; i < str.length(); i++) {
			list.add(str.charAt(i));
		}

		ListIterator<Character> iter = list.listIterator();
		while (iter.hasNext())
			iter.next();

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			char oper = s.charAt(0);
			if (oper == 'L') {
				if (iter.hasPrevious())
					iter.previous();
			} else if (oper == 'D') {
				if (iter.hasNext())
					iter.next();
			} else if (oper == 'B') {
				if (iter.hasPrevious()) {
					iter.previous();
					iter.remove();
				}
			} else {
				char c = s.charAt(2);
				iter.add(c);
			}
		}

		for (char c : list)
			bw.write(c);

		bw.flush();
		bw.close();
	}
}
//https://www.acmicpc.net/problem/1406