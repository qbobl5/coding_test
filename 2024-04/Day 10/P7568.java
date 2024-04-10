import java.io.*;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N=Integer.parseInt(br.readLine());
		int[][] people=new int[N][3];
		for(int i=0;i<N;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			people[i][0]=Integer.parseInt(st.nextToken());
			people[i][1]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<N-1;i++) {
			for(int j=i+1;j<N;j++) {
				if(people[i][0]>people[j][0] && people[i][1]>people[j][1]) {
					people[j][2]+=1;
				} else if(people[i][0]<people[j][0] && people[i][1]<people[j][1]) {
					people[i][2]+=1;
				}
			}
		}
		
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<N;i++) sb.append(people[i][2]+1+" ");
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
