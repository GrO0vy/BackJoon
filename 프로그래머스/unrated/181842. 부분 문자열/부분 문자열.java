class Solution {
    public int solution(String str1, String str2) {
        int answer = 1;
        if(str2.equals(str2.replace(str1,""))) answer = 0;
        return answer;
    }
}