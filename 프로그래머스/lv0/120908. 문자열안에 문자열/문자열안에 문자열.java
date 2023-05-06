class Solution {
    public int solution(String str1, String str2) {
        int answer = 2;
        if(str1.length() > str1.replace(str2,"").length()) answer = 1;
        return answer;
    }
}