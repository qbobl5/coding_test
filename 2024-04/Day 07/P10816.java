import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		br.readLine();
		String input1=br.readLine();
		String[] arr1=input1.split(" ");
		
		Map<Integer, Integer> cardMap=new HashMap<>();
		for(String s:arr1) {
			int i=Integer.parseInt(s);
			if(cardMap.containsKey(i)) cardMap.put(i, cardMap.get(i)+1);
			else cardMap.put(i, 1);
		}
		
		br.readLine();
		String input2=br.readLine();
		String[] arr2=input2.split(" ");
		br.close();
		
		StringBuilder sb=new StringBuilder();
		for(String s:arr2) {
			int i=Integer.parseInt(s);
			if(cardMap.get(i)!=null) sb.append(cardMap.get(i)+" ");
			else sb.append("0 ");
		}
		
		bw.write(sb.toString());
		bw.close();
	}

}
