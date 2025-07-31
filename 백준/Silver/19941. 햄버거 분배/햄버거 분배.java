import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> hamburgers = new LinkedList<>();
        Queue<Integer> persons = new LinkedList<>();

        String table = br.readLine();
        int result = 0;

        for(int i = 0; i < N; i++){
            if(table.charAt(i) == 'H') {
                while(!persons.isEmpty() && i - persons.peek() > K){
                    persons.poll();
                }

                if(!persons.isEmpty()){
                    persons.poll();
                    result++;
                }
                else hamburgers.offer(i);
            }
            else{
                while(!hamburgers.isEmpty() && i - hamburgers.peek() > K){
                    hamburgers.poll();
                }

                if(!hamburgers.isEmpty()){
                    hamburgers.poll();
                    result++;
                }
                else persons.offer(i);
            }
        }

        System.out.println(result);
    }
}