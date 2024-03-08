package s5;
import java.io.*;
import java.util.*;

public class P1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		String[] arr=input.split("");
		List<Integer> list=new ArrayList<>();
		for(String s:arr) list.add(Integer.parseInt(s));
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return i2 - i1;
			}
		});
		for(int i:list) System.out.print(i);
	}

}
