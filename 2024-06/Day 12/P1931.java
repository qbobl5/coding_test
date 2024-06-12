package greedy;

import java.io.*;
import java.util.*;

public class P1931 {
	
	static int N; // 회의의 수
	static int[][] meetings; // 회의 목록

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		meetings = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) return o1[0] - o2[0];
				return o1[1] - o2[1];
			}
		});
		
		int time = meetings[0][1];
		int idx = 0;
		int cnt = 1;
		while(idx < N - 1) {
			idx ++;
			if(time > meetings[idx][0]) continue;
			time = meetings[idx][1];
			cnt ++;
		}
		
		System.out.println(cnt);
	}

}
