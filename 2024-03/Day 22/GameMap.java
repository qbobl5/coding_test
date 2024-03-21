package bfs;

import java.util.*;

public class GameMap {
	
	public static int solution(int[][] maps) {
		int n=maps.length-1;
		int m=maps[0].length-1;
		
		Queue<int[]> queue=new LinkedList<>();
		queue.add(new int[] {0, 0, 0});
		int x=0, y=0, cnt=1;
		
		while(!queue.isEmpty()) {
			int[] root=queue.poll();
			x=root[0];
			y=root[1];
			cnt=root[2];
			
			if(x==n && y==m) return cnt+1;
			int[][] nodes={{x+1, y, cnt},{x, y+1, cnt},{x-1, y, cnt},{x, y-1, cnt}};
			
			for(int i=0;i<nodes.length;i++) {
				int row=nodes[i][0];
				int cal=nodes[i][1];
				int tmp=cnt;
				if(row<0 || row>n || cal<0 || cal>m) continue;
				if(maps[row][cal]==0) continue;
				queue.add(new int[] {row, cal, tmp+1});
				maps[row][cal]=0;
			}
		}
        return -1;
	}

	public static void main(String[] args) {
		//int[][] maps= {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
		//int[][] maps= {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,0},{0,0,0,0,1}};
		//int[][] maps= {{1,0,1,1,1},{1,1,1,1,1},{1,0,0,0,0},{1,1,1,1,1},{1,1,1,1,1}};
		int[][] maps= {{1},{1}};
		System.out.println(solution(maps));
	}

}
