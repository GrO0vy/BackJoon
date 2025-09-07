import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        Map<Integer, Problem> map = new HashMap<>();
        PriorityQueue<Problem> asc = new PriorityQueue<>((o1, o2) -> {
            if(o1.level != o2.level) return o1.level - o2.level;
            return o1.num - o2.num;
        });
        PriorityQueue<Problem> desc = new PriorityQueue<>((o1, o2) -> {
            if(o1.level != o2.level) return o2.level - o1.level;
            return o2.num - o1.num;
        });
        
        StringTokenizer st;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
                
            int num = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
                
            Problem problem = new Problem(num, level);
            map.put(num, problem);
                
            asc.offer(problem);
            desc.offer(problem);
        }
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            
            String op = st.nextToken();
            
            if(op.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                
                Problem problem = new Problem(num, level);
                
                map.put(num, problem);
                asc.offer(problem);
                desc.offer(problem);
            }
            else if(op.equals("solved")){
                int removedNum = Integer.parseInt(st.nextToken());
                Problem removedProblem = map.get(removedNum);
                
                asc.remove(removedProblem);
                desc.remove(removedProblem);
                map.remove(removedNum);
            }
            else{
                int type = Integer.parseInt(st.nextToken());
                
                if(type == 1){
                    sb.append(desc.peek().num + "\n");    
                }
                else{
                    sb.append(asc.peek().num + "\n");
                }
            }
        }
        
        System.out.println(sb.toString());
    }
    
    static class Problem{
        int num;
        int level;
        
        public Problem(int num, int level){
            this.num = num;
            this.level = level;
        }
    }
}