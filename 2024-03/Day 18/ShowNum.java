package practice;

public class ShowNum {
	
	public static int solution(int n) {
		int cnt=1;
		for(int i=1;i<=n/2;i++) {
			int sum=0;
			for(int j=i;j<n;j++) {
				sum+=j;
				if(sum==n) {
					cnt++;
					break;
				} else if(sum>n) break;
			}
		}
        return cnt;
    }

	public static void main(String[] args) {
		int n=15;
		System.out.println(solution(n));
	}

}
