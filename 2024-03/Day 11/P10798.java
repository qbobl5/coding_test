package b1;
import java.io.*;

public class P10798 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[][] matrix=new String[5][];
		int max=0;
		for(int i=0;i<5;i++) {
			String input=br.readLine();
			String[] str=input.split("");
			matrix[i]=str;
			if(str.length>max) max=str.length;
		}
		br.close();
		
		for(int i=0;i<max;i++) {
			for(int j=0;j<5;j++) {
				try {
					bw.write(matrix[j][i]);
				} catch (Exception e) {
					continue;
				}
			}
		}
		bw.close();
	}

}
