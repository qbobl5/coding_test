import java.io.*;

public class Main {
	static int result=0;
	
	public static void binomial(int n, int k) {
		if(k>n) return;
		if(k<0) return;
		
		int top=1;
		for(int i=n;i>0;i--) {
			if(n-k==i) break;
			top*=i;
		}
		
		int bottom=1;
		for(int i=k;i>0;i--) bottom*=i;
		
		result=top/bottom;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		String[] arr=input.split(" ");
		
		int N=Integer.parseInt(arr[0]);
		int K=Integer.parseInt(arr[1]);
		binomial(N, K);
		
		System.out.println(result);
		br.close();
	}

}
