import java.io.*;
import java.util.StringTokenizer;

public class Main {
	static int blue=0;
	static int white=0;
	static boolean[][] paper;
	
	public static void checkPaper(int row, int cal, int n) {
		boolean color=paper[row][cal];
		
		for(int i=row;i<row+n;i++) {
			for(int j=cal;j<cal+n;j++) {
				if(paper[i][j]!=color) {
					int tmp=n/2;
					checkPaper(row, cal, tmp);
					checkPaper(row+tmp, cal, tmp);
					checkPaper(row, cal+tmp, tmp);
					checkPaper(row+tmp, cal+tmp, tmp);
					return;
				}
			}
		}
		
		if(color) blue+=1;
		else white+=1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		paper=new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				if(st.nextToken().equals("1")) paper[i][j]=true;
			}
		}
		
		checkPaper(0, 0, N);
		System.out.println(white+"\n"+blue);
	}

}
