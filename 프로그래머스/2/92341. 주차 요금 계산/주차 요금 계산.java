import java.util.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        HashMap<String, Info> log = new HashMap<>();
        
        for(String record: records){
            String[] detail = record.split(" ");
            
            if(detail[2].equals("IN")){
                if(!log.containsKey(detail[1])){
                    log.put(detail[1], new Info(detail[1]));
                }
                
                log.get(detail[1]).carIn(calTime(detail[0]));
            }
            else{
                log.get(detail[1]).carOut(calTime(detail[0]));
            }
        }
        
        PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) -> o1.number.compareTo(o2.number));
        
        for(Info info: log.values()){
            if(info.timeOut == 23 * 60 + 59) info.carOut(23 * 60 + 59);
            
            pq.offer(info);
        }
        
        answer = new int[pq.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll().calCharge(fees);
        }
        
        return answer;
    }
    
    private int calTime(String time){
        String[] info = time.split(":");
        
        return Integer.parseInt(info[0]) * 60 + Integer.parseInt(info[1]);
    }
    
    class Info {
        String number;
        int timeIn;
        int timeOut;
        int totalTime;
        int charge;
        
        public Info(String number){
            this.number = number;
        }
        
        void carIn(int timeIn){
            this.timeIn = timeIn;
            this.timeOut = 23 * 60 + 59;
        }
        
        void carOut(int timeOut){
            this.timeOut = timeOut;
            totalTime += timeOut - timeIn;
        }
        
        int calCharge(int[] fees){
            int basicTime = fees[0];
            int basicPrice = fees[1];
            int unitTime = fees[2];
            int unitPrice = fees[3];
                
            charge += basicPrice;
            
            if(totalTime > basicTime){
                totalTime -= basicTime;
                int count = (int) Math.ceil(totalTime / (double)unitTime);
                charge += unitPrice * count; 
            }
            
            return charge;
        }
    }
}