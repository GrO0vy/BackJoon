import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        Queue<Integer> buildingQueue = new LinkedList<>();
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
            buildingQueue.add(i);
        }

        Stack<Integer> buildingStack = new Stack<>();
        long cnt = 0;
        while(!buildingQueue.isEmpty()){
            int next = buildingQueue.poll();
            if(buildingStack.isEmpty() || arr[next] < arr[buildingStack.peek()]) buildingStack.push(next);
            else{
                while(!buildingStack.isEmpty() && arr[next] >= arr[buildingStack.peek()]){
                    cnt += next - buildingStack.pop() - 1;
                }
                buildingStack.push(next);
            }
        }

        while(!buildingStack.isEmpty()) cnt += N - buildingStack.pop() - 1;

        System.out.println(cnt);
    }
}