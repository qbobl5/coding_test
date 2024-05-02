import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		int num=Integer.parseInt(input);
		
		int min=9*(input.length()-1)+(input.charAt(0)-49);
		boolean chk=true;
		for(int i=num-min;i<num;i++) {
			String target=String.valueOf(i);
			String[] str=target.split("");
			
			int cnt=i;
			for(String s:str) cnt+=Integer.parseInt(s);
			
			if(num==cnt) {
				chk=false;
				System.out.println(i);
				break;
			}
		}
		
		if(chk) System.out.println(0);
	}

}
