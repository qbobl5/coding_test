import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int E; // 지구 (1 ~ 15)
	static int S; // 태양 (1 ~ 28)
	static int M; // 달 (1 ~ 19)
	
	static int year; // 연도
	
	static void findYear() {
		int e = 1;
		int s = 1;
		int m = 1;
		
		while(e != E || s != S || m != M) {
			year += 1;
			e += 1;
			s += 1;
			m += 1;
			
			if(e > 15) e = 1;
			if(s > 28) s = 1;
			if(m > 19) m = 1;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 변수 선언
		StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값 받기
		
		E = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		year = 1;
		
		findYear(); // 연도 찾기
		System.out.println(year); // 결과 출력
	}

}
