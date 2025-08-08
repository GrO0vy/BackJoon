import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[0] != o2[0]) return o1[0] - o2[0];
                
                return o1[1] - o2[1];
            }
        });
        
        int idx = 0;
        int time = jobs[0][0];
        
        PriorityQueue<Task> pq = new PriorityQueue<>();
        pq.offer(new Task(idx, jobs[idx][0], jobs[idx][1]));
        idx++;
            
        while(!pq.isEmpty()){
            Task current = pq.poll();
            
            time = Math.max(time + current.length, current.requestTime + current.length);
            answer += time - current.requestTime; 
            
            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(new Task(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(idx < jobs.length && pq.isEmpty()){
                pq.offer(new Task(idx, jobs[idx][0], jobs[idx][1]));
                idx++;
            } 
        }
        
        return answer / jobs.length;
    }
    
    class Task implements Comparable<Task>{
        int num;
        int requestTime;
        int length;
        
        public Task(int num, int requestTime, int length){
            this.num = num;
            this.requestTime = requestTime;
            this.length = length;
        }
        
        public int compareTo(Task o){
            if(this.length != o.length) return this.length - o.length;
            if(this.requestTime != o.requestTime) return this.requestTime - o.requestTime;
            
            return this.num - o.num;
        }
    }
}