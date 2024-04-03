import java.util.Arrays;

public class BinarySearchTest {
	static int[] arr; // binarySearch에서 돌 배열
	static int cnt=0; // 일치하는 수가 몇 개 있는지 체크할 변수
	
	public static void binarySearch(int num, int idx, int min, int max) {
		if(arr[idx]==num) { // 일치하는 경우
			cnt++;
			return;
		}
		
		if(idx-min<2) {
			if(min==0 && arr[min]==num) cnt++;
			return;
		}
		
		if(max-idx<2) {
			if(max==arr.length-1 && arr[max]==num) cnt++;
			return;
		}
		
		if(arr[idx]>num) { // 찾는 수보다 해당 인덱스의 수가 더 큰 경우
			binarySearch(num, min+(idx-min)/2, min, idx);
		} else { // 91, 4, 0, 8 -> 91, 6, 4, 8 -> 91, 7, 6, 8 // 찾는 수보다 해당 인덱스의 수가 더 작은 경우
			binarySearch(num, idx+(max-idx)/2, idx, max);
		}
	}

	public static void main(String[] args) {
		arr=new int[]{11, 91, 20, 2, 8, 59, 33, 10, 4};
		Arrays.sort(arr);
		
		int[] target= {10, 3, 4, 6, 2, 33};
		int n=arr.length-1;
		for(int i:target) { binarySearch(i, n/2, 0, n); }
		
		System.out.println(cnt);
	}

}
