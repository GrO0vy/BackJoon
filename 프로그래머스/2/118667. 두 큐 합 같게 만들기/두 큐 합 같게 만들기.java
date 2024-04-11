import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        
        long target = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for(int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            sum1 += queue1[i];
            sum2 += queue2[i];
            target += queue1[i] + queue2[i];
        }
        
        if(target % 2 != 0) return -1;
        target /= 2;
        
        while(true){
            if(answer > (queue1.length + queue2.length) * 2) return -1;
            
            if(sum1 == sum2) break;
            else if(sum1 > sum2){
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                q2.offer(num);
            }
            else{
                int num = q2.poll();
                sum2 -= num;
                sum1 += num;
                q1.offer(num);
            }
            
            answer++;
        }
        
        return answer;
    }
}