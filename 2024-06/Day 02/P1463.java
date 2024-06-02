import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력 변수 선언
		int n = Integer.parseInt(br.readLine()); // 정수 n
		
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {n, 0}); // root = 정수 n, cnt = 0
		
		while(!queue.isEmpty()) {
			int[] target = queue.poll(); // queue 선입선출
			int num = target[0]; // 현재 수
			int cnt = target[1]; // 계산을 한 횟수
			
			/* 1이 된 경우 */
			if(num == 1) {
				System.out.println(cnt);
				break;
			}
			
			if(num % 3 == 0) queue.add(new int[] {num/3, cnt+1}); // 3으로 나누어지는 경우 3으로 나눈 값 넣기
			if(num % 2 == 0) queue.add(new int[] {num/2, cnt+1}); // 2로 나누어지는 경우 2로 나눈 값 넣기
			queue.add(new int[] {num-1, cnt+1}); // 1을 뺀 값 넣기
		}
	}

}
