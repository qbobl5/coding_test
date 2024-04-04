import java.io.*;

public class Main {
	
	public static boolean compare(String str) {
		int size=str.length();
		for(int i=0;i<size/2;i++) {
			if(str.charAt(i)!=str.charAt(size-i-1)) return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		
		while(!input.equals("0")) {
			if(compare(input)) System.out.println("yes");
			else System.out.println("no");
			input=br.readLine();
		}
		
		br.close();
	}

}
