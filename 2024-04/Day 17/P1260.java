import java.io.*;
import java.util.*;

public class Main {
	/* 입출력 */
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb=new StringBuilder();
	
	/* 그래프 */
	static List<List<Integer>> list;
	
	/* 기타 변수 */
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	
	/* 정점 방문 여부 체크용 변수 */
	static boolean[] check;
	
	/**
	 * list를 dfs 탐색하여 출력한다
	 * @param start 시작하는 정점의 번호
	 */
	static void dfs(int start) {
		if(start>N-1) return; // 정점이 범위 초과
		if(check[start]) return; // 이미 방문한 경우
		
		check[start]=true;
		sb.append(start+1+" ");
		
		List<Integer> tmp=list.get(start); // 정점과 연결된 다른 정점 리스트
		for(int i=0;i<tmp.size();i++) {
			int node=tmp.get(i); // 연결된 정점의 번호
			
			if(!check[node]) { // 아직 방문 되지 않은 번호인 경우 dfs 탐색
				dfs(node);
			}
		}
	}
	
	/**
	 * list를 bfs 탐색하여 출력한다
	 * @param start 시작하는 정점의 번호
	 */
	static void bfs(int start) {
		/* bfs 탐색에 필요한 변수 생성 */
		Queue<Integer> queue=new LinkedList<>();
		
		/* bfs 탐색을 시작하는 정점 추가 */
		queue.add(start);
		check[start]=true;
		
		while(!queue.isEmpty()) {
			int target=queue.poll(); // 정점의 번호
			sb.append(target+1+" ");
			
			List<Integer> tmp=list.get(target); // 정점과 연결된 다른 정점 리스트
			for(int i=0;i<tmp.size();i++) {
				int node=tmp.get(i); // 연결된 정점의 번호
				
				if(!check[node]) { // 아직 방문 되지 않은 번호인 경우 queue에 추가
					queue.add(node);
					check[node]=true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		/* 입력값 받아오기 */
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); 
		M=Integer.parseInt(st.nextToken()); 
		int V=Integer.parseInt(st.nextToken())-1; // 탐색을 시작할 정점의 번호
		
		list=new ArrayList<>();
		check=new boolean[N];
		
		/* 정점의 개수만큼 리스트 추가 */
		for(int i=0;i<N;i++) {
			list.add(new ArrayList<>());
		}
		
		/* 간선의 개수만큼 입력값 받기 */
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x=Integer.parseInt(st.nextToken())-1; // 간선 1 번호
			int y=Integer.parseInt(st.nextToken())-1; // 간선 2 번호
			
			list.get(x).add(y); // 간선 연결
			list.get(y).add(x); // 간선 연결
		}
		
		/* 정점의 번호 정렬 */
		for(int i=0;i<N;i++) {
			List<Integer> tmp=list.get(i);
			tmp.sort(Comparator.naturalOrder());
		}
		
		/* dfs 탐색 수행 */
		dfs(V);
		sb.append("\n");
		
		/* bfs 탐색 수행 */
		check=new boolean[N]; // 초기화
		bfs(V);
		
		/* 출력값 넣어주기 */
		bw.append(sb.toString());
		
		/* 입출력 종료 */
		bw.close();
		br.close();
	}

}
