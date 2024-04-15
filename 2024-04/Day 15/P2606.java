import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		int computer=Integer.parseInt(br.readLine());
		List<List<Integer>> list=new ArrayList<>();
		for(int i=0;i<computer;i++) {
			list.add(new ArrayList<>());
		}
		
		int connect=Integer.parseInt(br.readLine());
		for(int i=0;i<connect;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			list.get(x).add(y);
			list.get(y).add(x);
		}
		
		int cnt=0;
		boolean[] check=new boolean[computer];
		Queue<Integer> queue=new LinkedList<>();
		queue.add(0);
		check[0]=true;
		
		while(!queue.isEmpty()) {
			int target=queue.poll();
			cnt+=1;
			
			List<Integer> tmp=list.get(target);
			for(int i=0;i<tmp.size();i++) {
				int num=tmp.get(i);
				if(!check[num]) {
					queue.add(num);
					check[num]=true;
				}
			}
		}
		
		System.out.println(cnt-1);
	}

}
