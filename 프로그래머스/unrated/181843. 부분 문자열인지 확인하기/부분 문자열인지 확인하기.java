class Solution {
    public int solution(String my_string, String target) {
        int answer = 1;
        if(my_string.equals(my_string.replace(target,""))) answer =0;
        return answer;
    }
}