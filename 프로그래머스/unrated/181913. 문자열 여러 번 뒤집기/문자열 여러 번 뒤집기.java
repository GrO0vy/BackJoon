class Solution {
    public String solution(String my_string, int[][] queries) {
        String answer = "";
        String[] letters = my_string.split("");
        
        for(int i = 0; i < queries.length; i++){
            int start = queries[i][0];
            int end = queries[i][1];
            for(int j = start; j <= (start + end) / 2; j++){
                String temp = letters[j];
                letters[j] = letters[start+end-j];
                letters[start+end-j] = temp;
            }
        }
        for(int i = 0; i < letters.length; i++){
            answer += letters[i];
        }
        return answer;
    }
}