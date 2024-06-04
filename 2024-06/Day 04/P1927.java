import java.io.*;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		Queue<Integer> queue = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(queue.isEmpty()) sb.append("0\n");
				else sb.append(queue.poll()+"\n");
			} else queue.add(x);
		}
		
		bw.append(sb.toString());
		bw.close();
		br.close();
	}

}
