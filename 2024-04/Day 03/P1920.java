import java.util.*;

public class Main {
	static int[] arr;
	static boolean chk;
	
	public static void binarySearch(int num, int min, int max) {
		if(max<min) return;
		
		int idx=min+(max-min)/2;
		
		if(arr[idx]==num) {
			chk=true;
			return;
		}
		
		if(arr[idx]>num) {
			binarySearch(num, min, idx-1);
		} else {
			binarySearch(num, idx+1, max);
		}
	}

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		arr=new int[n];
		for(int i=0;i<n;i++) arr[i]=sc.nextInt();
		Arrays.sort(arr);
		
		int m=sc.nextInt();
		for(int i=0;i<m;i++) {
			int num=sc.nextInt();
			chk=false;
			binarySearch(num, 0, n-1);
			if(chk) System.out.println(1);
			else System.out.println(0);
		}
	}

}
