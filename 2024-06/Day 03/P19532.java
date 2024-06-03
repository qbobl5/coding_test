import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/* a ~ f 입력값 저장 */
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		int f = Integer.parseInt(st.nextToken());
		
		/* 답이 될 x, y 선언 */
		int x = 0;
		int y = 0;
		
		if(a == 0 || b == 0 || d == 0 || e == 0) {
			/* 0이 되는 수가 있는 경우 그에 맞게 계산 */
			if(a == 0) {
				y = c / b;
				x = (f - e * y) / d;
			} else if(d == 0) {
				y = f / e;
				x = (c - b * y) / a;
			} else if(b == 0) {
				x = c / a;
				y = (f - d * x) / e;
			} else {
				x = f / d;
				y = (c - a * x) / b;
			}
		} else {
			/* 각 절댓값의 합이 더 작은 경우에 맞게 계산 */
			if((Math.abs(a) + Math.abs(d)) > (Math.abs(b) + Math.abs(e))) {
				x = (c * e - f * b) / (a * e - d * b);
				y = (c - a * x) / b;
			} else {
				y = (c * d - f * a) / (b * d - e * a);
				x = (c - b * y) / a;
			}
		}
		
		System.out.println(x + " " + y);
	}

}
