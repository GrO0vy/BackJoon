class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        String result ="";
        
        for(int i =0; i<myString.length(); i++){
            if(myString.charAt(i) == 'A') result += "B";
            else result += "A";
        }
        
        if(result.contains(pat)) answer = 1;
        return answer;
    }
}