class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        for(int i = -1000; ; i++){
            int result = 0;
            for(int j = i; j<i+num; j++){
                result += j;
            }
            if(result == total){
                for(int j = i; j<i+num; j++){
                    answer[j-i] = j;
                }
                break;
            }
        }
        return answer;
    }
}