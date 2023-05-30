class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] available = {"aya", "ye", "woo", "ma"};
        
        for(int i =0; i<babbling.length; i++){
            String str = babbling[i];
            for(int j=0; j<available.length; j++){
                str = str.replaceFirst(available[j],"0");
            }
            if(str.replace("0","").length() == 0) answer++;
        }
        return answer;
    }
}