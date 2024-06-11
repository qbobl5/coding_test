package greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11047 {
	
	static int N; // 동전의 종류
	static int K; // 가치의 합

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int[] coins = new int[N];
		for(int i=0; i<N; i++) coins[i] = Integer.parseInt(br.readLine());
		Arrays.sort(coins);
		
		int cnt = 0;
		for(int i=N-1; i>=0; i--) {
			if(coins[i] > K) continue;
			cnt += K / coins[i];
			K %= coins[i];
			if(K == 0) break;
		}
		
		System.out.println(cnt);
	}

}
