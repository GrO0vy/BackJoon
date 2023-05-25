class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 2;
        for(int i=0; i<dic.length; i++){
            String str = dic[i];
            
            if(str.length() == spell.length){
                for(int j=0; j<spell.length; j++){
                    str = str.replaceFirst(spell[j],"");
                }
            }
            if(str.length() == 0) {
                answer = 1;
                break;
            }
        }
        return answer;
    }
}