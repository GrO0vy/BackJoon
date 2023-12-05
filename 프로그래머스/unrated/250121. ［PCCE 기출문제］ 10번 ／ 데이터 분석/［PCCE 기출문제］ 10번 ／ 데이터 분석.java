import java.util.*;
class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        
        if(sort_by.equals("code")){
            Arrays.sort(data, (o1, o2) ->{
                return o1[0] - o2[0];    
            });
        }
        else if(sort_by.equals("date")){
            Arrays.sort(data, (o1, o2) ->{
                return o1[1] - o2[1];    
            });
        }
        else if(sort_by.equals("maximum")){
            Arrays.sort(data, (o1, o2) ->{
                return o1[2] - o2[2];    
            });
        }
        else{
            Arrays.sort(data, (o1, o2) ->{
                return o1[3] - o2[3];    
            });
        }
        
        if(ext.equals("code")){
            for(int i = 0; i < data.length; i++){
                if(data[i][0] < val_ext) answer.add(data[i]);
            }
        }
        else if(ext.equals("date")){
            for(int i = 0; i < data.length; i++){
                if(data[i][1] < val_ext) answer.add(data[i]);
            }
        }
        else if(ext.equals("maximum")){
            for(int i = 0; i < data.length; i++){
                if(data[i][2] < val_ext) answer.add(data[i]);
            }
        }
        else{
            for(int i = 0; i < data.length; i++){
                if(data[i][3] < val_ext) answer.add(data[i]);
            }
        }
        return answer;
    }
}