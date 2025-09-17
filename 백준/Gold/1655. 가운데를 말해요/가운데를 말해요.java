import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>((o1, o2) -> o2 - o1);
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int number = Integer.parseInt(br.readLine());

            if(asc.size() == desc.size()) desc.offer(number);
            else asc.offer(number);
            
            if(!asc.isEmpty() && !desc.isEmpty() && asc.peek() < desc.peek()){
                asc.offer(desc.poll());
                desc.offer(asc.poll());
            }

            sb.append(desc.peek() + "\n");
        }
        
        System.out.println(sb.toString());
    }
}