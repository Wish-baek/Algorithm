import java.util.*;

public class Bronze1173 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();	//운동할 시간 5
		int m = sc.nextInt();	//최소 맥박 70
		int M = sc.nextInt();	//최대 맥박 120
		int T = sc.nextInt();	//운동 시 맥박 증가량 25
		int R = sc.nextInt();	//휴식 시 맥박 감소량 15

		int time = 0;
		int etime = 0;
		int now = m;
		
		while(etime<N) {
			
			if( now + T <= M ) {
				now+=T;
				time++;
				etime++;
			}
			else {
				if( now - R < m) {
					time++;
					now=m;
				}
				else {
					time++;
					now-=R;
				}
			}
			if(now + T > M && now==m) {
				System.out.println(-1);
				System.exit(0);
			}

		}
		System.out.println(time);
	}

}
