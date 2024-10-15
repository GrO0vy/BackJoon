class Solution {
    int answer;
    int cnt = 0;
    char[] members = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    boolean[] visited = new boolean[8];
    
    public int solution(int n, String[] data) {
        answer = 0;
        
        search("", data);
        return answer;
    }
    
    void search(String line, String[] data){
        if(line.length() == 8){
            if(isPossible(line, data)) answer++;
            return;
        }
        
        for(int i = 0; i < 8; i++){
            if(!visited[i]){
                visited[i] = true;
                search(line + members[i], data);
                visited[i] = false;
            }
        }
    }
    
    boolean isPossible(String line, String[] data){
        for(String d: data){
            char p1 = d.charAt(0);
            char p2 = d.charAt(2);
            char op = d.charAt(3);
            int distance = d.charAt(4) - '0';
            
            if(op == '>'){
                if(Math.abs(line.indexOf(p1) - line.indexOf(p2)) <= distance + 1){
                    return false;    
                }     
            }
            else if(op == '<'){
                if(Math.abs(line.indexOf(p1) - line.indexOf(p2)) >= distance + 1){
                    return false;      
                }    
            }
            else{
                if(Math.abs(line.indexOf(p1) - line.indexOf(p2)) != distance + 1){
                    return false;     
                }        
            }
        }
        
        return true;
    }
}