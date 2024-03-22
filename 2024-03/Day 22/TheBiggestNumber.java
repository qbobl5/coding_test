package sort;

import java.util.*;

public class TheBiggestNumber {

	public static String solution(int[] numbers) {
		String[] str=new String[numbers.length];
		for(int i=0;i<numbers.length;i++) str[i]=String.valueOf(numbers[i]);

		Arrays.sort(str, new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				return Integer.parseInt(s2+s1) - Integer.parseInt(s1+s2);
			}
		});

		if(str[0].equals("0")) return "0";
		String rst="";
		for(String s:str) rst+=s;
		return rst;
	}

	public static void main(String[] args) {
		int[] numbers= {3, 30, 34, 5, 9};
		System.out.println(solution(numbers));
	}

}
