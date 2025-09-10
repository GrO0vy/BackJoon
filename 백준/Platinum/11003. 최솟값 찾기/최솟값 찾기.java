import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        Deque<Node> deque = new ArrayDeque<>();
        
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < N; i++){
            int addNum = Integer.parseInt(st.nextToken());
            
            while(!deque.isEmpty() && deque.peekLast().value >= addNum){
                deque.pollLast();
            }
            
            while(!deque.isEmpty() && i - deque.peek().index > L - 1){
                deque.poll();
            }
            
            deque.offerLast(new Node(i, addNum));
            
            sb.append(deque.peek().value + " ");
        }
        
        System.out.println(sb.toString());
    }
    
    static class Node{
        int index;
        int value;
        
        public Node(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}