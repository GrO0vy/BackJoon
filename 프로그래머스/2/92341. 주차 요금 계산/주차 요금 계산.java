import java.util.*;

class Solution {
    int basicCharge;
    int basicTime;
    int unitTime;
    int unitCharge;
    
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        basicTime = fees[0]; basicCharge = fees[1]; unitTime = fees[2]; unitCharge = fees[3];
        
        HashMap<String, Car> info = new HashMap<>();
        
        for(String record: records){
            String[] log = record.split(" ");
            if(log[2].equals("IN")) {
                int inTime = Integer.parseInt(log[0].substring(0, 2)) * 60 + Integer.parseInt(log[0].substring(3));
                
                if(info.containsKey(log[1])) info.get(log[1]).carIn(inTime);
                else{
                    Car car = new Car();
                    car.carIn(inTime);
                    info.put(log[1], car);
                }
            }
            else{
                int outTime = Integer.parseInt(log[0].substring(0, 2)) * 60 + Integer.parseInt(log[0].substring(3));
                info.get(log[1]).carOut(outTime);
            }
        }
        
        answer = new int[info.size()];
        Object[] keys = info.keySet().toArray();
            
        Arrays.sort(keys);
            
        for(int i = 0; i < keys.length; i++){
            Car car = info.get(keys[i]);
            if(car.outTime == 0) car.carOut(23 * 60 + 59);
            answer[i] = car.calculation();
        }
        
        return answer;
    }
    
    class Car{
        int inTime;
        int outTime;
        int totalTime;
        int charge;
        
        public void carIn(int inTime){
            this.inTime = inTime;
            this.outTime = 0;
        }
        
        public void carOut(int outTime){
            this.outTime = outTime;
            this.totalTime += outTime - inTime;
        }
        
        public int calculation(){
            if(totalTime > 0){
                charge += basicCharge;
                if(totalTime > basicTime) 
                    charge += Math.ceil((totalTime - basicTime) * 1.0 / unitTime) * unitCharge;
            }
            
            return this.charge;
        }
    }
}