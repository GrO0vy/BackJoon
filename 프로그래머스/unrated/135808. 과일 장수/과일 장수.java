import java.util.Arrays;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        Arrays.sort(score);
        for(int i = score.length - 1; i >= 0; i -= m){
            if(i - m < -1) break;
            int min = k + 1;
            for(int j = i; j > i - m; j--){
                if(score[j] < min) min = score[j];
            }
            answer += min * m;
        }
        return answer;
    }
}