package pcce;

public class NextBox {
	
	public static int solution(String[][] board, int h, int w) {
		int cnt=0;
		String color=board[h][w];
		if(h!=0) if(board[h-1][w].equals(color)) cnt++;
		if(h!=board.length-1) if(board[h+1][w].equals(color)) cnt++;
		if(w!=0) if(board[h][w-1].equals(color)) cnt++;
		if(w!=board[0].length-1) if(board[h][w+1].equals(color)) cnt++;
		
        return cnt;
    }

	public static void main(String[] args) {
		String[][] board= {{"yellow", "green", "blue"}, {"blue", "green", "yellow"}, {"yellow", "blue", "blue"}};
		int h=0;
		int w=1;
		System.out.println(solution(board, h, w));
	}

}
