import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int test = Integer.parseInt(br.readLine());
		
		for(int i=0; i<test; i++) {
			Map<String, Integer> map=new HashMap<>();
			int N = Integer.parseInt(br.readLine());
			
			for(int j=0; j<N; j++) {
				String s = br.readLine();
				String[] tmp = s.split(" ");
				
				if(map.containsKey(tmp[1])) {
					map.put(tmp[1], map.get(tmp[1])+1);
				} else {
					map.put(tmp[1], 1);
				}
			}
			
			Set<String> set = map.keySet();
			int cnt = 1;
			
			for(String s : set) {
				cnt *= (map.get(s) + 1);
			}
			
			cnt-=1;
			sb.append(cnt+"\n");
		}
		
		bw.append(sb.toString());
		bw.close();
		br.close();
	}

}
