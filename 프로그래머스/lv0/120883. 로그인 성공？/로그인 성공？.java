class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String answer = "";
        String id = id_pw[0];
        String pw = id_pw[1];
        
        boolean idExist = false;
        boolean correctPw = false;
        
        for(int i=0; i<db.length; i++){
            if(id.equals(db[i][0])){
                idExist = true;
                if(pw.equals(db[i][1])) correctPw = true;  
            }
        }
        if(!idExist) answer = "fail";
        else if(!correctPw) answer = "wrong pw";
        else answer = "login";
        
        return answer;
    }
}