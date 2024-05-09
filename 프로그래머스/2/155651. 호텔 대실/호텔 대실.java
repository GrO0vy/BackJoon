import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = -1;
        
        Arrays.sort(book_time, new Comparator<>(){
            public int compare(String[] o1, String[] o2){
                int[] time1 = getTime(o1);
                int[] time2 = getTime(o2);
                
                return time1[0] - time2[0];
            }
        });
        
        PriorityQueue<String[]> useList = new PriorityQueue<>((o1, o2) -> {
            int[] time1 = getTime(o1);
            int[] time2 = getTime(o2);
                
            return time1[1] - time2[1];
        });
        
        for(int i = 0; i < book_time.length; i++){
            if(!useList.isEmpty()){
                while(!useList.isEmpty() && 
                      getTime(useList.peek())[1] + 10 <= getTime(book_time[i])[0])
                {
                    useList.poll();        
                }
            }
            
            useList.offer(book_time[i]);
            answer = Math.max(answer, useList.size());
        }
        
        return answer;
    }
    
    int[] getTime(String[] time){
        String[] start = time[0].split(":");
        String[] end = time[1].split(":");
        
        int startToInt = Integer.parseInt(start[0]) * 60 + Integer.parseInt(start[1]);
        int endToInt = Integer.parseInt(end[0]) * 60 + Integer.parseInt(end[1]);
        
        return new int[]{startToInt, endToInt};
    }
}