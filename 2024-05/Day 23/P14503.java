import java.io.*;
import java.util.*;

public class Main {
	static int N; // room 의 행 개수
	static int M; // room 의 열 개수
	static int[][] room; // 방
	static int cnt = 0; // 청소된 칸의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		room = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		int startRow = Integer.parseInt(st.nextToken());
		int startCal = Integer.parseInt(st.nextToken());
		int startDir = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				String token = st.nextToken();
				if(token.equals("1")) room[i][j] = 1;
			}
		}
		
		try {
			dfs(new int[] {startRow, startCal, startDir});
		} catch (Exception e) {
			// 종료
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int[] start) throws Exception {
		int row = start[0];
		int cal = start[1];
		int dir = start[2];
		
		// 1. 현재 칸이 아직 청소되지 않은 경우
		if(room[row][cal] == 0) {
			cnt += 1;
			room[row][cal] = -1;
		}
		
		int[][] nds = {{row-1, cal}, {row, cal+1}, {row+1, cal}, {row, cal-1}};
		int size = nds.length;
		
		for(int i=0; i<size; i++) {
			dir -= 1;
			if(dir < 0) {
				dir += size;
			}
			
			int r = nds[dir][0];
			int c = nds[dir][1];
			
			if(r < 0 || c < 0 || r >= N || c >= M) {
				continue;
			}
			
			// 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
			if(room[r][c] == 0) {
				dfs(new int[] {r, c, dir});
				return;
			}
		}
		
		// 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
		dir = start[2];
		if(dir >= nds.length/2) {
			dir -= nds.length;
		}
		
		int[] back = nds[dir + 2];
		int r = back[0];
		int c = back[1];
		
		if(r < 0 || c < 0 || r >= N || c >= M) {
			throw new Exception();
		}
		
		if(room[r][c] == 1) {
			throw new Exception();
		}
		
		dfs(new int[] {r, c, start[2]});
	}

}
