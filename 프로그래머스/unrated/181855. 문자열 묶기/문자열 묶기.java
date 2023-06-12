class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] result = new int[100000];
        for(int i = 0; i < strArr.length; i++){
            result[strArr[i].length()] += 1;
        }
        
    
        for(int i = 0; i < result.length; i++){
            if(answer < result[i]) answer = result[i];
        }
        return answer;
    }
}