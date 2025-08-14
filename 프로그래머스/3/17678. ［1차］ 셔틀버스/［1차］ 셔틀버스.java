import java.util.*;

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        
        Arrays.sort(timetable, new Comparator<>(){
            public int compare(String o1, String o2){
                String[] t1 = o1.split(":");
                String[] t2 = o2.split(":");
                
                int h1 = Integer.parseInt(t1[0]) * 60;
                int m1 = Integer.parseInt(t1[1]);
                int h2 = Integer.parseInt(t2[0]) * 60;
                int m2 = Integer.parseInt(t2[1]);
                
                return h1 + m1 - (h2 + m2);
            }
        });
        
        int time = 9 * 60;
        int idx = 0;
        
        while(idx < timetable.length && n > 0){
            int people = 0;
            
            String[] latestTime = {};
            
            for(int i = 1; i <= m; i++){
                if(idx >= timetable.length || !canGetOn(time, timetable[idx])) break;
                
                latestTime = timetable[idx].split(":");
                people++;
                idx++;
            }
            
            if(people < m){
                answer = String.format("%02d:%02d", time / 60, time % 60);    
            }
            else{
                int hour = Integer.parseInt(latestTime[0]);
                int minute = Integer.parseInt(latestTime[1]);
            
                minute += hour * 60 - 1;
            
                answer = String.format("%02d:%02d", minute / 60, minute % 60);        
            }
            
            time += t;
            n--;
        }
        
        return answer;
    }
    
    boolean canGetOn(int bus, String people){
        String[] time = people.split(":");
        
        int hour = Integer.parseInt(time[0]);
        int minute = Integer.parseInt(time[1]);
        
        return hour * 60 + minute <= bus;
    }
}