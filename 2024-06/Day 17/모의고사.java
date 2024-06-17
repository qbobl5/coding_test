class Solution {
    public int[] solution(int[] answers) {
        int[] score = new int[3]; // 삼인방이 답을 맞춘 횟수
        int[] stu1 = {1, 2, 3, 4, 5}; // 1번 수포자의 답
        int[] stu2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 2번 수포자의 답
        int[] stu3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 3번 수포자의 답
        
        for(int i=0; i<answers.length; i++) { // 삼인방이 답을 맞춘 횟수 계산
            if(stu1[i % stu1.length] == answers[i]) score[0] ++;
            if(stu2[i % stu2.length] == answers[i]) score[1] ++;
            if(stu3[i % stu3.length] == answers[i]) score[2] ++;
        }
        
        if(score[0] == score[1] && score[1] == score[2]) return new int[] {1, 2, 3};
        else if(score[0] > score[1] && score[0] > score[2]) return new int[] {1};
        else if(score[1] > score[2]) {
            if(score[0] == score[1]) return new int[] {1, 2};
            else return new int[] {2};
        } else if(score[2] != score[0] && score[2] != score[1]) return new int[] {3};
        else {
            if(score[2] == score[0]) return new int[] {1, 3};
            else return new int[] {2, 3};
        }
    }
}
