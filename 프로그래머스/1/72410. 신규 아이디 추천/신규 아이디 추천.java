class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1
        new_id = new_id.toLowerCase();
        
        // 2
        new_id = new_id.replaceAll("[^a-z|0-9|\\-|_|\\.]", "");
        
        // 3
        new_id = new_id.replaceAll("[\\.]{2,}","\\.");
        
        // 4
        new_id = new_id.replaceAll("^\\.|\\.$","");
        
        // 5
        if(new_id.length() == 0) new_id = "a";
        
        // 6
        if(new_id.length() >= 16) new_id = new_id.substring(0, 15);
        new_id = new_id.replaceAll("\\.$","");
        
        // 7
        char last = new_id.charAt(new_id.length() - 1);
        while(new_id.length() < 3){
            new_id += last;
        }
        
        answer = new_id;
        return answer;
    }
}