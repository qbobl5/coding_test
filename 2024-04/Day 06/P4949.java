import java.io.*;
import java.util.Stack;

public class Main {
	
	public static boolean chk(String str) {
		Stack<String> stack=new Stack<>();
		String[] arr=str.split("");
		
		for(int i=0;i<arr.length;i++) {
			if(arr[i].equals("(")) stack.add("(");
			else if(arr[i].equals(")")) {
				if(stack.isEmpty()) return false;
				String tmp=stack.peek();
				if(tmp.equals("(")) stack.pop();
				else return false;
			} else if(arr[i].equals("[")) stack.add("[");
			else if(arr[i].equals("]")) {
				if(stack.isEmpty()) return false;
				String tmp=stack.peek();
				if(tmp.equals("[")) stack.pop();
				else return false;
			}
		}
		
		if(stack.isEmpty()) return true;
		else return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		
		String input=br.readLine();
		while(!input.equals(".")) {
			if(chk(input)) bw.write("yes\n");
			else bw.write("no\n");
			input=br.readLine();
		}
		
		bw.close();
		br.close();
	}

}
