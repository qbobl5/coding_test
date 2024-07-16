class Solution {
    boolean solution(String s) {
        s = s.toUpperCase(); // 모두 대문자로 변경
        // a = 0 일때 p = 15, y = 24
        int p = 15;
        int y = 24;
        int pCnt = 0;
        int yCnt = 0;
        
        for(int i=0; i<s.length(); i++) {
            int tmp = s.charAt(i) - 'A';
            if(tmp == p) pCnt ++;
            else if(tmp == y) yCnt ++;
        }
        
        if(pCnt == yCnt) return true;
        else return false;
    }
}
