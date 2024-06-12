import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        Lecture[] lectures = new Lecture[plans.length];
        for(int i = 0; i < plans.length; i++){
            Lecture lecture = 
                new Lecture(plans[i][0], calTime(plans[i][1]), Integer.parseInt(plans[i][2]));
            
            lectures[i] = lecture;
        }
        
        Arrays.sort(lectures, new Comparator<>(){
            public int compare(Lecture o1, Lecture o2){
                return o1.start - o2.start;
            }
        });
        
        Stack<Lecture> process = new Stack<>();
        process.push(lectures[0]);
        
        int idx = 0;
        int curTime = lectures[0].start;
        
        for(int i = 1; i < lectures.length; i++){
            Lecture recent = process.peek();
            Lecture now = lectures[i];
            
            while(!process.isEmpty()){
                recent = process.peek();
                if(curTime + recent.remain <= now.start){
                    answer[idx++] = recent.name;
                    curTime += recent.remain;
                    process.pop();    
                }
                else break;
            }
            
            if(!process.isEmpty())
                recent.remain = curTime + recent.remain - now.start;
            
            process.push(now);
            curTime = now.start;
        }
        
        while(!process.isEmpty()){
            answer[idx++] = process.pop().name;
        }
        
        return answer;
    }
    
    class Lecture{
        String name;
        int start;
        int remain;
        
        public Lecture(String name, int start, int remain){
            this.name = name;
            this.start = start;
            this.remain = remain;
        }
    }
    
    int calTime(String time){
        String[] t = time.split(":");
        
        return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
    }
}