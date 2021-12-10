import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 입력 데이터
 * 8
 * 0 1 0 1 0 0 0 1
 * 2 (학생의 수)
 * 1 3 ( 앞의 숫자가 1이면 남자 2면 여자 / 뒷 숫자는 받은 숫자를 의미)
 * 2 3 ( 남자면 받은 수의 배수의 스위치 상태 변경, 여자는 좌우 대칭확인해서 변경 )
 * 출력 데이터
 * 1 0 0 0 1 1 0 1
 */

public class BOJ1244_switch {

	public static void main(String[] args) throws Exception {
		// 버퍼를 이용한 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		// 정수 N 을 입력받는다. 
		int N = Integer.parseInt(br.readLine());
		System.out.println(br);
		int[] swit = new int[N];
		
		// BufferedReader 클래스 메서드로 입력을 읽으면 라인 단위로 읽음
		// 그 문자열을 나누고 싶을 때 쓰는 것이 StringTokenizer 문자열을 토큰화한다.
		// 띄어쓰기로 구분 StringTokenizer(문자열);
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			swit[i] = Integer.parseInt(st.nextToken());
		}
		
		int stu = Integer.parseInt(br.readLine());
		for (int i = 0; i < stu; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			
			if (gender == 1) {
				for (int j = 0; j < N; j++) {
					if((j+1) % num == 0) {
						swit[j] = swit[j] == 0 ? 1 : 0;
					}
				}
			} else {
				swit[num-1] = swit[num-1] == 0 ? 1 : 0;
				for (int j = 1; j < N/2; j++) {
					if (num - 1 + j >= N || num - 1 - j < 0) {
						break;
					}
					if(swit[num-1-j] == swit[num-1+j]) {
						swit[num-1-j] = swit[num-1-j] == 0 ? 1 : 0;
						swit[num-1+j] = swit[num-1+j] == 0 ? 1 : 0;
					} else {
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			System.out.print(swit[i] + " ");
			if((i+1) % 20 == 0) {
				System.out.println();
			}
		}
	}
}
