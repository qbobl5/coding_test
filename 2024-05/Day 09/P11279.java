import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num == 0) {
				if(queue.isEmpty()) {
					sb.append("0\n");
				} else {
					sb.append(queue.poll()+"\n");
				}
			} else {
				queue.add(num);
			}
		}
		
		bw.append(sb.toString());
		bw.close();
		br.close();
	}

}
