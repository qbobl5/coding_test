import java.io.*;

public class P2775 {
	static StringBuilder sb=new StringBuilder();
	static int[][] building=new int[15][14];
	
	static void fillArr() {
		for(int i=0;i<14;i++) building[0][i]=(i+1);
		for(int i=1;i<15;i++) building[i][0]=1;
		
		for(int i=1;i<15;i++) {
			for(int j=1;j<14;j++) {
				building[i][j]=building[i-1][j]+building[i][j-1];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test=Integer.parseInt(br.readLine());
		fillArr();
		for(int t=0;t<test;t++) {
			int k=Integer.parseInt(br.readLine()); // 층
			int n=Integer.parseInt(br.readLine()); // 호
			sb.append(building[k][n-1]+"\n");
		}
		
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
