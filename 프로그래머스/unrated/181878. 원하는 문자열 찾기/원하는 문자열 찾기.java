class Solution {
    public int solution(String myString, String pat) {
        int answer = 1;
        
        if(myString.toUpperCase().equals(myString.toUpperCase().replace(pat.toUpperCase(),""))) answer = 0;
        return answer;
    }
}