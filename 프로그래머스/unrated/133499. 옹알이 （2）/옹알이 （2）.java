class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        String[] possible = new String[]{
            "aya", "ye", "woo", "ma"
        };
        
        for(String bab : babbling){
            for(String pos : possible){
                if(!(bab.replace(pos.repeat(2),"").equals(bab))) break;
                bab = bab.replace(pos," ");
            }
            if(bab.replaceAll("\\s+","").length() == 0) answer++;
        }
        
        return answer;
    }
}