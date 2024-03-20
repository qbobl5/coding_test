package practice;

import java.util.Arrays;

public class LottoRanking {
	public static int zero=0;
	public static int correct=0;
	public static int tmp=0;
	
	public static int rank(int score) {
		if(score==6) return 1;
		if(score==5) return 2;
		if(score==4) return 3;
		if(score==3) return 4;
		if(score==2) return 5;
		return 6;
	}

	public static int[] solution(int[] lottos, int[] win_nums) {
		Arrays.sort(lottos);
		Arrays.sort(win_nums);

		for(int i=0;i<lottos.length;i++) {
			if(lottos[i]==0) zero++;
			else break;
		}

		for(int i=zero;i<lottos.length;i++) {
			for(int j=tmp;j<win_nums.length;j++) {
				if(lottos[i]==win_nums[j]) correct++;
				else if(lottos[i]<win_nums[j]) {
					tmp=j;
					break;
				}
			}
		}

		return new int[]{rank(correct+zero), rank(correct)};
	}

	public static void main(String[] args) {
		int[] lottos= {44, 1, 0, 0, 31, 25};
		int[] win_nums= {31, 10, 45, 1, 6, 19};
		int[] result=solution(lottos, win_nums);
		for(int i:result) System.out.print(i+" ");
	}

}
