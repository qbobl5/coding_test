import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int n=Integer.parseInt(br.readLine());
		
		int[][] coor=new int[n][2];
		for(int i=0;i<n;i++) {
			String input=br.readLine();
			String[] tmp=input.split(" ");
			coor[i][0]=Integer.parseInt(tmp[0]);
			coor[i][1]=Integer.parseInt(tmp[1]);
		}
		br.close();
		
		Arrays.sort(coor, new Comparator<int[]>() {
			@Override
			public int compare(int[] arr1, int[] arr2) {
				if(arr1[1]==arr2[1]) return arr1[0] - arr2[0];
				return arr1[1] - arr2[1];
			}
		});
		
		StringBuilder sb=new StringBuilder();
		for(int[] arr:coor) sb.append(arr[0]+" "+arr[1]+"\n");
		bw.write(sb.toString());
		bw.close();
	}

}
