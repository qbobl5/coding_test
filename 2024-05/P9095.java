package B9371;

import java.io.*;

public class Main {
	
	/* 계산 메소드 */
	static int calcul(int n) {
		if(n == 0) return 1;
		else if(n == 1) return 2;
		else if(n == 2) return 4;
		else if(n == 3) return 7;
		else return 2 * calcul(n-1) - calcul(n-4);
	}

	public static void main(String[] args) throws IOException {
		/* 입출력 변수 선언 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		/* 테스트케이스의 수 입력 */
		int T = Integer.parseInt(br.readLine());
		
		/* 1부터 10까지 각 방법의 수 계산하여 값 저장 */
		int[] number = new int[10];
		
		for(int i=0; i<number.length; i++) {
			number[i] = calcul(i);
		}
		
		/* 테스트케이스 별 정답 출력 */
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<T; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(number[num-1]+"\n");
		}
		
		bw.append(sb.toString());
		bw.close();
		br.close();
	}

}
