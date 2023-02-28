import java.util.LinkedList;
import java.util.Scanner;

public class Silver1966 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();

			LinkedList<int[]> q = new LinkedList<>();
						
			
			for (int i = 0; i < N; i++) {
			
				q.offer(new int[] {i, sc.nextInt()});
			}
			
			int cnt = 0;

			
			while(true) {
				
				int[] temp = q.poll();
				boolean check = true;
				
				for(int i = 0; i < q.size(); i++) {
					if(temp[1]<q.get(i)[1]) {
						q.add(temp);
						
						for(int j = 0; j < i; j++) {
							q.add(q.poll());
						}
						check = false;
						break;
					}
				}
				
				if(check==false) continue;
				cnt++;
				if(temp[0]==M) break;
				
			}
			

			System.out.println(cnt);

		}

	}

}
//https://www.acmicpc.net/problem/1966