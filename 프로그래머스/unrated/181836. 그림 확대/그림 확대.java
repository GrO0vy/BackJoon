class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for(int i = 0; i < picture.length; i++){
            String row = "";
            for(int j = 0; j <picture[i].length(); j++){
                row = row + String.valueOf(picture[i].charAt(j)).repeat(k);
            }
            for(int j = 0; j < k; j++){
                answer[i*k + j] = row;
            }
        }
        return answer;
    }
}