class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int total = 0;
        int power = 1;
        
        for(int i=0; i<num_list.length; i++){
            total += num_list[i];
            power *= num_list[i];
        }
        
        if(total*total > power) answer = 1;
        
        return answer;
    }
}