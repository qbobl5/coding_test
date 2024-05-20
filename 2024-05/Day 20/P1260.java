import java.io.*;
import java.util.*;

public class Main {
	public static int N; // 정점의 개수
	public static int M; // 간선의 개수
	public static int V; // 탐색할 정점의 번호
	public static List<List<Integer>> graph; // 그래프
	
	public static StringBuilder sb = new StringBuilder();
	
	public static boolean[] check;
	
	public static void dfs(int node) {
		if(check[node]) return;
		
		check[node] = true;
		sb.append((node + 1) + " ");
		
		List<Integer> list = graph.get(node);
		
		for(int i=0; i<list.size(); i++) {
			dfs(list.get(i));
		}
	}
	
	public static void bfs() {
		check = new boolean[N];
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(V);
		check[V] = true;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			sb.append((node + 1) + " ");
			
			List<Integer> list = graph.get(node);
			
			for(int i=0; i<list.size(); i++) {
				int target = list.get(i);
				if(check[target]) continue;
				
				queue.add(target);
				check[target] = true;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken()) - 1;
		
		graph = new ArrayList<>();
		
		for(int i=0; i<N; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			graph.get(start).add(end);
			graph.get(end).add(start);
		}
		
		for(int i=0; i<N; i++) {
			List<Integer> tmp = graph.get(i);
			tmp.sort(new Comparator<Integer>() {
				@Override
				public int compare(Integer i1, Integer i2) {
					return i1 - i2;
				}
			});
		}
		
		check = new boolean[N];
		
		dfs(V);
		sb.append("\n");
		bfs();
		
		bw.write(sb.toString());
		bw.close();
	}

}
