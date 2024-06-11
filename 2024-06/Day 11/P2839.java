package greedy;

import java.io.*;

public class P2839 {
	
	static int N; // 배달해야 하는 설탕 (kg)
	static int smallBag = 0; // 3kg 봉지 개수
	static int bigBag = 0; // 5kg 봉지 개수
	
	static int countBag(int div, int mod) {
		if(mod == 1) { // N = 3 + ... + 1
			if(div >= 3) {
				div -= 3; // 3 + 3 + 3 + 1 을 10으로 변환하여 3 감소
				bigBag += 2; // 10 = 5*2
			} else return -1;
		} else if(mod == 2) { // N = 3 + ... + 2
			div --; // 3 + 2 를 5로 변환하여 1 감소
			bigBag += 1; // 5 = 5*1
		}
		
		bigBag += (div / 5) * 3; // 3 + 3 + 3 + 3 + 3 을 15로 변환하여 그 개수만큼 bigBag에 추가 (15 = 5*3)
		smallBag += div % 5; // 위에서 남은 나머지의 개수만큼 smallBag에 추가
		
		return bigBag + smallBag;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int div = N / 3; // 전체 무게를 3으로 나눈 값
		int mod = N % 3; // 전체 무게를 3으로 나눈 나머지
		
		System.out.println(countBag(div, mod));
	}

}
