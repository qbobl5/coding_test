import java.io.*;

public class Main {
	static int N; // 기준 숫자
	static int X; // 기준 숫자의 자릿수
	
	static int cnt; // 새로운 수의 자릿수
	
	static int squareTen(int t) {
		int num = 1;
		for(int i=0; i<t; i++) {
			num *= 10;
		}
		return num;
	}
	
	static void countNum() {
		/* 자릿수 전까지의 계산 */
		for(int i=1; i<X; i++) {
			cnt += 9 * squareTen(i-1) * i;
		}
		
		/* 최종 자릿수에서의 계산 */
		cnt += (N - squareTen(X-1) + 1) * X;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 변수 선언
		String s = br.readLine(); // 입력값 입력 받기
		
		N = Integer.parseInt(s); // 정수로 변환
		X = s.length(); // 자릿수 확인
		
		cnt = 0; // 새로운 수의 자릿수 초기화
		countNum(); // 새로운 수의 자릿수 계산
		System.out.println(cnt); // 결과 출력
	}

}
