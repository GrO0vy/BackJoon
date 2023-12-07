import java.util.*;
class Solution {
    public List<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> answer = new ArrayList<>();
        
        String[] field = new String[]{"code", "date", "maximum", "remain"};
        
        int sortIdx = 0;
        int extIdx = 0;
        
        for(int i = 0; i <= 3; i++){
            if(field[i].equals(ext)) extIdx = i;
            if(field[i].equals(sort_by)) sortIdx = i;
        }
        
        final int si = sortIdx;
        
        Arrays.sort(data, (o1, o2) ->{
            return o1[si] - o2[si];    
        });
  
        for(int i = 0; i < data.length; i++){
            if(data[i][extIdx] < val_ext) answer.add(data[i]);
        }

     
        return answer;
    }
}