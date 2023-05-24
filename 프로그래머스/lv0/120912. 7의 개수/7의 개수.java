class Solution {
    public int solution(int[] array) {
        int answer = 0;
        for(int i=0; i<array.length; i++){
            for(;array[i] > 0;){
                if(array[i] % 10 == 7) answer++;
                array[i] /= 10;
            }
        }
        return answer;
    }
}