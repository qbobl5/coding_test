import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 변수 선언
		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken()); // 수빈이의 위치
		int end = Integer.parseInt(st.nextToken()); // 동생의 위치

		// 수빈이와 동생의 거리를 표현하는 배열
		// 최대 거리 == 100001 (수빈 0, 동생 100000의 경우)
		int[] way = new int[100001];

		Queue<Integer> queue = new LinkedList<>(); // bfs에 사용할 queue 선언
		queue.add(start); // root 삽입
		way[start] = 1; // (걸린 시간 + 1)로 배열값 지정

		while(!queue.isEmpty()) {
			int num = queue.poll(); // 현재 노드 뽑기
			int time = way[num];

			// 수빈이가 동생에게 도착
			if(num == end) break;

			// 앞으로 한 칸 이동
			if(num < 100000) {
				if(way[num+1] == 0) {
					way[num+1] = time + 1;
					queue.add(num+1);
				}
			}

			// 뒤로 한 칸 이동
			if(num > 0) {
				if(way[num-1] == 0) {
					way[num-1] = time + 1;
					queue.add(num-1);
				}
			}

			// 순간 이동
			if(num <= 50000) {
				if(way[num*2] == 0) {
					way[num*2] = time + 1;
					queue.add(num*2);
				}
			}
		}

		System.out.println(way[end] - 1);
	}

}
