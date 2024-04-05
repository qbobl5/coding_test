import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(br.readLine());
		
		List<int[]> list=new ArrayList<>();
		for(int i=0;i<test;i++) {
			String input=br.readLine();
			String[] tmp=input.split(" ");
			int x=Integer.parseInt(tmp[0]);
			int y=Integer.parseInt(tmp[1]);
			list.add(new int[] {x, y});
		}
		
		list.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] i1, int[] i2) {
				if(i1[1]==i2[1]) return i1[0] - i2[0];
				return i1[1] - i2[1];
			}
		});
		
		for(int[] arr:list) System.out.println(arr[0]+" "+arr[1]);
	}

}
