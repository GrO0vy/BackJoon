class Solution {
    public int solution(String my_string) {
        int answer;
        String[] sik = my_string.split(" ");
        answer = Integer.valueOf(sik[0]);
        
        boolean isPlus =true;
        
        for(int i=1; i<sik.length; i++){
            if(i % 2 == 1) {
                if(sik[i].equals("+")) isPlus = true;
                else isPlus =false;
            }
            else{
                if(isPlus) answer+= Integer.valueOf(sik[i]);
                else answer -= Integer.valueOf(sik[i]);
            } 
        }
        return answer;
    }
}