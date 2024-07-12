import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[100001];
        int result = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        queue.offer(new Node(N, 0));

        while(!queue.isEmpty()){
            Node current = queue.poll();

            if(current.pos == K){
                result = current.time;
                break;
            }

            if(!visited[current.pos]){
                visited[current.pos] = true;
                int next;
                int nextTime = current.time + 1;

                for(int i = 0; i < 3; i++){
                    if(i == 0) next = current.pos - 1;
                    else if(i == 1) next = current.pos + 1;
                    else {
                        next = current.pos * 2;
                        nextTime -= 1;
                    }

                    if(next >= 0 && next <= 100000 && !visited[next]) queue.offer(new Node(next, nextTime));
                }
            }
        }

        System.out.println(result);
    }

    static class Node{
        int pos;
        int time;

        public Node(int pos, int time){
            this.pos = pos;
            this.time = time;
        }
    }
}