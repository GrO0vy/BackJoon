class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        for(int i = 0; i < strings.length - 1; i++){
            for(int j = i + 1; j < strings.length; j++){
                if(strings[j].charAt(n) < strings[i].charAt(n)){
                    String temp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = temp;
                }
                else if(strings[j].charAt(n) == strings[i].charAt(n)){
                    if(strings[j].compareTo(strings[i]) < 0){
                        String temp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = temp;
                    }
                }
            }
        }
        answer = strings;
        return answer;
    }
}