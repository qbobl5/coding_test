import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		int N=Integer.parseInt(br.readLine());
		
		Queue<Integer> hip=new PriorityQueue<>(new Comparator<Integer>() {
			public int compare(Integer i1, Integer i2) {
				if(Math.abs(i1)==Math.abs(i2)) return i1 - i2;
				return Math.abs(i1) - Math.abs(i2);
			}
		});
		
		for(int i=0;i<N;i++) {
			int num=Integer.parseInt(br.readLine());
			if(num!=0) hip.add(num);
			else {
				if(hip.isEmpty()) {
					sb.append("0\n");
					continue;
				}
				
				int poll=hip.poll();
				sb.append(poll+"\n");
			}
		}
		
		bw.append(sb.toString());
		bw.close();
		br.close();
	}

}
