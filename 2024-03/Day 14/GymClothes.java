package greedy;

public class GymClothes {
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int[] student=new int[n];
		for(int i:lost) student[i-1]--;
		for(int i:reserve) student[i-1]++;

		for(int i=0;i<student.length;i++) {
			if(student[i]==-1) {
				if(i==0) {
					if(student[i+1]==1) {
						student[i]++;
						student[i+1]--;
					}
				} else if(i==n-1) {
					if(student[i-1]==1) {
						student[i]++;
						student[i-1]--;
					}
				} else {
					if(student[i-1]==1 || student[i+1]==1) {
						if(student[i-1]==1) {
							student[i]++;
							student[i-1]--;
						} else {
							student[i]++;
							student[i+1]--;
						}
					}
				}
			}
		}
		
		int result=0;
		for(int i:student) if(i==-1) result++;
		
		return n-result;
    }

	public static void main(String[] args) {
		int n=3;
		int[] lost= {3};
		int[] reserve= {1};
		System.out.println(solution(n, lost, reserve));
	}

}
