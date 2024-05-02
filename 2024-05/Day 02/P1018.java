import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		boolean[][] board=new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s=br.readLine();
			String[] str=s.split("");
			for(int j=0;j<M;j++) {
				if(str[j].equals("W")) board[i][j]=true;
			}
		}
		
		Queue<Integer> queue=new PriorityQueue<>();
		
		for(int i=0;i<N-7;i++) {
			for(int j=0;j<M-7;j++) {
				int cnt=0;
				boolean chk=board[i][j];
				for(int k=i;k<i+8;k++) {
					for(int l=j;l<j+8;l++) {
						if(board[k][l]!=chk) cnt+=1;
						chk=!chk;
					}
					chk=!chk;
				}
				queue.add(64-cnt);
				queue.add(cnt);
			}
		}
		
		System.out.println(queue.poll());
	}

}
