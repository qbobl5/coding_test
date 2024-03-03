package s4;
import java.io.*;
import java.util.*;

public class P10866 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int size=Integer.parseInt(br.readLine());
		
		Deque<Integer> dq=new LinkedList<>();
		String[] words= {"push_front", "push_back", "pop_front", "pop_back", "size", "empty", "front", "back"};
		
		for(int i=0;i<size;i++) {
			String input=br.readLine();
			String[] tmp=input.split(" ");
			String s=tmp[0];
			
			if(s.equals(words[0])) dq.addFirst(Integer.parseInt(tmp[1]));
			else if(s.equals(words[1])) dq.addLast(Integer.parseInt(tmp[1]));
			else if(s.equals(words[2])) {
				if(dq.isEmpty()) bw.append("-1\n");
				else bw.append(String.valueOf(dq.pollFirst())+"\n");
			} else if(s.equals(words[3])) {
				if(dq.isEmpty()) bw.append("-1\n");
				else bw.append(String.valueOf(dq.pollLast()+"\n"));
			} else if(s.equals(words[4])) bw.append(String.valueOf(dq.size())+"\n");
			else if(s.equals(words[5])) {
				if(dq.isEmpty()) bw.append("1\n");
				else bw.append("0\n");
			} else if(s.equals(words[6])) {
				if(dq.isEmpty()) bw.append("-1\n");
				else bw.append(String.valueOf(dq.peekFirst())+"\n");
			} else if(s.equals(words[7])) {
				if(dq.isEmpty()) bw.append("-1\n");
				else bw.append(String.valueOf(dq.peekLast())+"\n");
			}
		}
		bw.close();
		br.close();
	}

}
