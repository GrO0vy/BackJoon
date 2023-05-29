class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        String[][] sik = new String[quiz.length][5];
        
        for(int i=0; i<quiz.length; i++){
            sik[i] = quiz[i].split(" ");
        }
        
        for(int i=0; i<quiz.length; i++){
            if(sik[i][1].equals("+")){
                int result = Integer.parseInt(sik[i][0]) + Integer.parseInt(sik[i][2]);
                if(result == Integer.parseInt(sik[i][4])) answer[i] ="O";
                else answer[i] ="X";
            }
            
            else{
                int result = Integer.parseInt(sik[i][0]) - Integer.parseInt(sik[i][2]);
                if(result == Integer.parseInt(sik[i][4])) answer[i] ="O";
                else answer[i] ="X";
            }
        }
        
        return answer;
    }
}