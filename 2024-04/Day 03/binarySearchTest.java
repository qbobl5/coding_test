import java.util.Arrays;

public class BinarySearchTest {
	static int[] arr; // binarySearch에서 돌 배열
	static int cnt=0; // 일치하는 수가 몇 개 있는지 체크할 변수
	
	public static void binarySearch(int num, int min, int max) {
		if(max<min) return;
		
		int idx=min+(max-min)/2;
		
		if(arr[idx]==num) { // 일치하는 경우
			cnt++;
			return;
		}
		
		if(arr[idx]>num) { // 찾는 수보다 해당 인덱스의 수가 더 큰 경우
			binarySearch(num, min, idx-1);
		} else { // 찾는 수보다 해당 인덱스의 수가 더 작은 경우
			binarySearch(num, idx+1, max);
		}
	}

	public static void main(String[] args) {
		arr=new int[]{11, 91, 20, 2, 8, 59, 33, 10, 4};
		Arrays.sort(arr);
		
		int[] target= {10, 3, 4, 6, 2, 33};
		for(int i:target) { 
			if(arr.length<=0) break;
			binarySearch(i, 0, arr.length-1);
		}
		
		System.out.println(cnt);
	}

}
