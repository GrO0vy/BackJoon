import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for(int i = 0; i <= citations[citations.length - 1]; i++){
            int leftCnt = 0;
            int rightCnt = 0;
            
            for(int j = 0; j < citations.length; j++){
                if(citations[j] == i){
                    leftCnt++;
                    rightCnt++;
                }
                else if(citations[j] > i) rightCnt++;
                else leftCnt++;
            }
            
            if(rightCnt >= i && leftCnt <= i) answer = i;
        }
        
        return answer;
    }
}