package dfs;

public class TargetNumber {
	public static int[] mainNum; // 제공되는 숫자 배열
	public static int targetN; // 타겟 넘버
	public static int cnt=0; // 타겟 넘버를 만드는 방법의 수
	
	public static void cal(int index, int tmp, boolean type) {
		// index가 0보다 작거나 배열의 크기보다 크면 재귀 종료
		if(index<0 || index>mainNum.length) return;
		
		if(index==mainNum.length) {
			// 타겟 넘버와 일치하는지 확인
			if(tmp==targetN) cnt++;
			if(-tmp==targetN) cnt++;
			return;
		} else {
			if(type) tmp+=mainNum[index];
			else tmp-=mainNum[index];
			cal(index+1, tmp, true);
			// 계산 두 번 방지를 위해 if문 사용
			if(index!=mainNum.length-1) cal(index+1, tmp, false);
		}
	}
	
	public static int solution(int[] numbers, int target) {
		mainNum=numbers;
		targetN=target;
		cal(0, 0, true);
        return cnt;
    }

	public static void main(String[] args) {
		int[] numbers= {4, 1, 2, 1};
		int target=4;
		System.out.println(solution(numbers, target));
	}

}
