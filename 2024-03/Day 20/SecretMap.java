package kakao;

public class SecretMap {
	static int[][] map;
	
	public static void putMap(String bin, int index) {
		String[] str=bin.split("");
		int sub=map.length-str.length;
		for(int i=sub, j=0;i<map[0].length;i++, j++) {
			if(str[j].equals("1")) map[index][i]=1;
		}
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		map=new int[n][n];
		for(int i=0;i<arr1.length;i++) {
			String bin=Integer.toBinaryString(arr1[i]);
			String bin2=Integer.toBinaryString(arr2[i]);
			putMap(bin, i);
			putMap(bin2, i);
		}
		String[] result=new String[n];
		for(int i=0;i<n;i++) {
			String s="";
			for(int j=0;j<n;j++) {
				if(map[i][j]==1) s+="#";
				else s+=" ";
			}
			result[i]=s;
		}
        return result;
    }

	public static void main(String[] args) {
		int n=5;
		int[] arr1= {9, 20, 28, 18, 11};
		int[] arr2= {30, 1, 21, 17, 28};
		String[] result=solution(n, arr1, arr2);
		for(String s: result) System.out.print(s+" ");
	}

}
