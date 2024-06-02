import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static final int mod = 1000000000; // 나머지를 구할 상수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 변수 선언
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // 정수의 합
		int k = Integer.parseInt(st.nextToken()); // 정수의 개수
		
		int[][] dp = new int[n+1][k+1]; // 2차원 배열
		
		for(int i=0; i<=k; i++) dp[0][i] = 1; // n=0일때 항상 1
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k; j++) {
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % mod; // 나머지의 경우 위쪽칸+왼쪽칸의 합
			}
		}
		
		System.out.println(dp[n][k]);
	}

}
