import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input=br.readLine();
		br.close();
		
		String[] arr=input.split(" ");
		int N=Integer.parseInt(arr[0]);
		int K=Integer.parseInt(arr[1]);
		
		List<Integer> list=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			list.add(i);
		}
		
		int cnt=1;
		int idx=0;
		StringBuilder sb=new StringBuilder();
		
		sb.append("<");
		while(list.size()!=1) {
			if(idx==list.size()) {
				idx=0;
			}
			
			if(cnt==K) {
				int result=list.remove(idx);
				sb.append(result+", ");
				cnt=1;
			} else {
				cnt++;
				idx++;
			}
		}
		sb.append(list.get(0)+">");
		
		bw.write(sb.toString());
		bw.close();
	}

}
