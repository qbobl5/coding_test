import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int cnt=1;
		int target=666;
		
		while(cnt<N) {
			target+=1;
			String tmp=String.valueOf(target);
			if(tmp.contains("666")) cnt+=1;
		}
		
		System.out.println(target);
	}

}
