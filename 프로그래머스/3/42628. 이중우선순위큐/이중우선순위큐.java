import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for(String operation: operations){
            String[] op = operation.split(" ");
            
            String command = op[0];
    
            if(command.equals("I")){
                int num = Integer.parseInt(op[1]);
                
                maxHeap.offer(num);
                minHeap.offer(num);
            }
            else{
                int signal = Integer.parseInt(op[1]);
                
                if(signal == 1){
                    minHeap.remove(maxHeap.poll());
                }
                else{
                    maxHeap.remove(minHeap.poll());
                }
            }
        }
        
        if(!maxHeap.isEmpty()) answer[0] = maxHeap.poll();
        if(!minHeap.isEmpty()) answer[1] = minHeap.poll();
        
        return answer;
    }
}