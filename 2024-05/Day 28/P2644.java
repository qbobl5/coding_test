import java.io.*;
import java.util.*;

public class Main {
	static int N; // 사람의 수
	static List<List<Integer>> graph; // 가족 그래프
	static boolean[] check; // 체크용 배열
	
	static int target; // 촌수를 계산할 사람
	static int result = -1;
	
	static void dfs(int start, int cnt) throws Exception {
		if(start == target) {
			result = cnt;
			throw new Exception();
		}
		
		if(check[start]) {
			return;
		}
		
		List<Integer> list = graph.get(start);
		check[start] = true;
		cnt += 1;
		
		for(int i=0; i<list.size(); i++) {
			dfs(list.get(i), cnt);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		graph = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		check = new boolean[N];
		
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()) - 1;
		target = Integer.parseInt(st.nextToken()) - 1;
		
		int M = Integer.parseInt(br.readLine());
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		try {
			dfs(start, 0);
		} catch (Exception e) {}
		
		System.out.println(result);
	}

}
