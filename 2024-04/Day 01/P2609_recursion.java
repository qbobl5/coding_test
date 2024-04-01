import java.io.*;

public class Main {
	static int max;
	
	public static void maxCal(int x, int y) {
		if(x%y==0) return;
		max=x%y;
		maxCal(y, max);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		String[] inputArr=input.split(" ");
		
		int x=Integer.parseInt(inputArr[0]);
		int y=Integer.parseInt(inputArr[1]);
		
		if(x<y) {
			int tmp=y;
			y=x;
			x=tmp;
		}
		
		if(x==y) {
			System.out.println(x+"\n"+x);
		} else {
			max=y;
			maxCal(x, y);
			System.out.println(max);
			System.out.println((x/max)*y);
		}
	}

}
