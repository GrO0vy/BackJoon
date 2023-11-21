import java.util.StringTokenizer;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        for(int i = 0; i < park.length; i++){
            for(int j = 0; j < park[i].length(); j++){
                if(park[i].charAt(j) == 'S') answer = new int[]{i, j};
            }
        }
        
        for(String route: routes){
            StringTokenizer st = new StringTokenizer(route);
            
            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());
            
            if(direction.equals("E")){
                if(answer[1] + distance < park[0].length()){
                    boolean isMoveable = true;
                    for(int i = answer[1] + 1; i <= answer[1] + distance ; i++){
                        if(park[answer[0]].charAt(i) == 'X') {
                            isMoveable = false;
                            break;
                        }
                    }
                    if(!isMoveable) continue;
                }
                else continue;
                
                answer[1] += distance;
            }
            else if(direction.equals("W")){
                if(answer[1] - distance >= 0){
                    boolean isMoveable = true;
                    for(int i = answer[1] - 1; i >= answer[1] - distance ; i--){
                        if(park[answer[0]].charAt(i) == 'X') {
                            isMoveable = false;
                            break;
                        }
                    }
                    if(!isMoveable) continue;
                }
                else continue;
                
                answer[1] -= distance;
            }
            else if(direction.equals("S")){
                if(answer[0] + distance < park.length){
                    boolean isMoveable = true;
                    for(int i = answer[0] + 1; i <= answer[0] + distance ; i++){
                        if(park[i].charAt(answer[1]) == 'X'){
                            isMoveable = false;
                            break;
                        }
                    }
                    if(!isMoveable) continue;
                }
                else continue;
                
                answer[0] += distance;
            }
            else{
                if(answer[0] - distance >= 0){
                    boolean isMoveable = true;
                    for(int i = answer[0] - 1; i >= answer[0] - distance ; i--){
                        if(park[i].charAt(answer[1]) == 'X') {
                            isMoveable = false;
                            break;
                        }
                    }
                    if(!isMoveable) continue;
                }
                else continue;
                
                answer[0] -= distance;
            }
        }
        
        return answer;
    }
}