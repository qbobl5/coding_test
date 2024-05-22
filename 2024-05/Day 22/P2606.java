import java.io.*;
import java.util.*;

public class Main {
	static int comCnt; // 컴퓨터의 수
	static int netCnt; // 네트워크 쌍의 수
	static List<List<Integer>> graph; // 그래프
	static boolean[] check; // 체크용 배열
	static int virus; // 바이러스에 걸린 컴퓨터의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		comCnt = Integer.parseInt(br.readLine());
		netCnt = Integer.parseInt(br.readLine());
		
		graph = new ArrayList<>();
		check = new boolean[comCnt];
		
		for(int i=0; i<comCnt; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<netCnt; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int com1 = Integer.parseInt(st.nextToken()) - 1;
			int com2 = Integer.parseInt(st.nextToken()) - 1;
			
			graph.get(com1).add(com2);
			graph.get(com2).add(com1);
		}
		
		virus = -1;
		dfs(0);
		System.out.println(virus);
	}
	
	static void dfs(int node) {
		if(check[node]) return;
		
		check[node] = true;
		virus += 1;
		
		List<Integer> tmpList = graph.get(node);
		
		for(int i=0; i<tmpList.size(); i++) {
			dfs(tmpList.get(i));
		}
	}

}
