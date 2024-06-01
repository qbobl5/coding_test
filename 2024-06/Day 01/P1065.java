import java.io.*;

public class Main {
	static int cnt;
	
	static void findCnt(int n) {
		for(int i=100; i<=n; i++) {
			String tmp = String.valueOf(i); // 각 자리의 수를 구분하기 위해 String 값으로 변경
			if(calcul(tmp)) cnt += 1; // 각 자리 수가 등차인지 확인하고 맞다면 cnt 1 증가
		}
	}
	
	static boolean calcul(String s) {		
		int sub = s.charAt(0) - s.charAt(1); // 등차 기준
		
		for(int i=1; i<s.length()-1; i++) {
			int tmp = s.charAt(i) - s.charAt(i+1); // 나머지 등차
			if(sub != tmp) return false; // 기준과 다를 경우 false 
		}
		
		return true; // 모두 기준을 만족하는 경우 true
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 변수 선언
		String input = br.readLine(); // 입력값 받기
		
		int size = input.length(); // 입력값의 사이즈
		int n = Integer.parseInt(input); // 기준이 되는 자연수
		
		if(size <= 2) {
			// 수의 길이가 2보다 작으면 1부터 n까지 모든 수가 등차수열을 만족
			System.out.println(n);
		} else {
			// 수의 길이가 3 이상인 경우
			cnt = 99; // 99까지 등차수열 만족
			findCnt(n); // 100부터 n까지 등차수열을 만족하는 수를 찾기
			System.out.println(cnt);
		}
	}

}
