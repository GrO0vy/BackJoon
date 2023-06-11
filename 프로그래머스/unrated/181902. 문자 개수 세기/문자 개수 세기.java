class Solution {
    public int[] solution(String my_string) {
        int[] answer = new int[52];
        char upperLetter = 'A';
        char lowerLetter = 'a';
        
        int idx = 0;
        for(int i =0; i<26; i++){
            String letter = (char)(upperLetter + i) +"";
            answer[idx++] = my_string.length() - my_string.replace(letter,"").length();
            my_string = my_string.replace(letter,"");
        }
        for(int i =0; i<26; i++){
            String letter = (char)(lowerLetter + i)+"";
            answer[idx++] = my_string.length() - my_string.replace(letter,"").length();
            my_string = my_string.replace(letter,"");
        }
        return answer;
    }
}