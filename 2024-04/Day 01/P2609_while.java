import java.io.*;

public class Main {
	
	public static int maxCal(int x, int y) {
		if(x<y) {
			int max=y;
			y=x;
			x=max;
		} else if(x==y) {
			System.out.println(x);
			System.out.println(x);
			return -1;
		}
		
		int z=x%y;
		while(z!=0) {
			int tmp=x%y;
			x=y;
			y=tmp;
			z=x%y;
		}
		
		return y;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String input=br.readLine();
		String[] inputArr=input.split(" ");
		
		int x=Integer.parseInt(inputArr[0]);
		int y=Integer.parseInt(inputArr[1]);
		
		int max=maxCal(x, y);
		if(max!=-1) {
			System.out.println(max);
			System.out.println((x/max)*y);
		}
	}

}
