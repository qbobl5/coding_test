import java.io.*;

public class Main {
	
	public static int cal(int n) {
		if(n==0) return 1;
		if(n==1) return 1;
		if(n==2) return 2;
		return cal(n-3)+cal(n-2)+cal(n-1);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb=new StringBuilder();
		
		int test=Integer.parseInt(br.readLine());
		
		for(int i=0;i<test;i++) {
			int target=Integer.parseInt(br.readLine());
			sb.append(cal(target)+"\n");
		}
		
		bw.append(sb.toString());
		bw.close();
		br.close();
	}

}
