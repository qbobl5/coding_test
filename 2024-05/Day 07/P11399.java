import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		br.readLine();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Queue<Integer> queue = new PriorityQueue<>();
		
		while(st.hasMoreTokens()) {
			queue.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 0;
		int tmp = 0;
		
		while(!queue.isEmpty()) {
			int time = queue.poll();
			cnt += time + tmp;
			tmp += time;
		}
		
		System.out.println(cnt);
		br.close();
	}

}
