import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int M;
	static char[][] campus;
	
	public static int bfs(int[] start) {
		int cnt=0;
		Queue<int[]> queue=new LinkedList<>();
		queue.add(start);
		
		while(!queue.isEmpty()) {
			int[] target=queue.poll();
			int raw=target[0];
			int cal=target[1];
			
			char c=campus[raw][cal];
			campus[raw][cal]='X';
			
			if(c=='X') {
				continue;
			} else if(c=='P') {
				cnt+=1;
			}
			
			int[][] nds= {{raw+1, cal}, {raw, cal+1}, {raw-1, cal}, {raw, cal-1}};
			
			for(int i=0;i<4;i++) {
				int tmpr=nds[i][0];
				int tmpc=nds[i][1];
				
				if(tmpr>=0 && tmpr<N && tmpc>=0 && tmpc<M) {
					queue.add(nds[i]);
				}
			}
		}
		
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		campus=new char[N][M];
		
		int[] start=new int[2];
		
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			
			for(int j=0;j<M;j++) {
				char c=s.charAt(j);
				
				if(c=='I') {
					start[0]=i;
					start[1]=j;
				}
				
				campus[i][j]=c;
			}
		}
		
		int cnt=bfs(start);
		
		if(cnt==0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}

}
