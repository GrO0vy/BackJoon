import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{N, 0});
        
        boolean[] visited = new boolean[100001];
        
        while(true){
            int[] node = queue.poll();
            int num = node[0];
            int time = node[1];
            
            if(visited[num]) continue;
            visited[num] = true;
            
            if(num == K){
                System.out.println(time);
                break;
            }
            
            if(num + 1 < 100001 && !visited[num + 1])
                queue.offer(new int[]{num + 1, time + 1});
            if(num - 1 >= 0 && !visited[num - 1])
                queue.offer(new int[]{num - 1, time + 1});
            if(num * 2 < 100001 && !visited[num * 2])
                queue.offer(new int[]{num * 2, time + 1});
        }
        
        sc.close();
    }
}