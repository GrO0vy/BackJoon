import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        s = s.substring(1, s.length() - 1);
        
        StringTokenizer st = new StringTokenizer(s,"{");
        answer = new int[st.countTokens()];
        
        PriorityQueue<String[]> pq = new PriorityQueue<>((o1, o2) ->{
            return o1.length - o2.length;
        });
        
        for(int i = 0; i < answer.length; i++){
            String str = st.nextToken();
            str = str.substring(0, str.indexOf('}'));
            String[] numbers = str.split(",");
            pq.offer(numbers);    
        }
        
        HashSet<Integer> set =  new HashSet<>();
        int idx = 0;
        while(!pq.isEmpty()){
            String[] numbers = pq.poll();
            
            for(int i = 0; i < numbers.length; i++){
                int num = Integer.parseInt(numbers[i]);
                if(!set.contains(num)){
                    set.add(num);
                    answer[idx++] = num;
                }
            }
        }
        return answer;
    }
}