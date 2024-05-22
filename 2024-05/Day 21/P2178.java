import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N; // 행의 개수
	static int M; // 열의 개수
	static boolean[][] maze; // 미로
	
	static int min = -1; // 최소의 칸 수
	
	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {0, 0, 1});
		maze[0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] root = queue.poll();
			
			int row = root[0];
			int cal = root[1];
			int cnt = root[2];
			
			if(row == (N-1) && cal == (M-1)) {
				if(min > cnt || min == -1) {
					min = cnt;
				}
			}
			
			int[][] nds = {{row+1, cal}, {row, cal+1}, {row-1, cal}, {row, cal-1}};
			
			for(int[] node:nds) {
				int r = node[0];
				int c = node[1];
				
				if(r < 0 || c < 0 || r >= N || c >= M) {
					continue;
				}
				
				if(maze[r][c]) {
					continue;
				}
				
				queue.add(new int[] {r, c, cnt+1});
				maze[r][c] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String input = br.readLine();
		String[] inputValue = input.split(" ");
		
		N = Integer.parseInt(inputValue[0]);
		M = Integer.parseInt(inputValue[1]);
		maze = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			input = br.readLine();
			String[] str = input.split("");
			
			for(int j=0; j<M; j++) {
				String s = str[j];
				
				if(s.equals("0")) {
					maze[i][j] = true;
				}
			}
		}
		
		bfs();
		System.out.println(min);
	}

}
