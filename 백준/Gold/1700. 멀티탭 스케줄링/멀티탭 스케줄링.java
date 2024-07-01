import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[K];
        Queue<Integer>[] machines = new Queue[K + 1];
        for(int i = 0; i <= K; i++){
            machines[i] = new LinkedList<>();
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < K; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            machines[arr[i]].offer(i);
        }

        HashSet<Integer> connected = new HashSet<>();
        int answer = 0;

        for(int i = 0; i < K; i++){
            machines[arr[i]].poll();

            if(connected.size() < N){
                connected.add(arr[i]);
            }
            else{
                if(!connected.contains(arr[i])){
                    int distance = -1;
                    int remove = 0;

                    for(int c: connected){
                        if(machines[c].isEmpty()){
                            remove = c;
                            break;
                        }
                        if(machines[c].peek() > distance) {
                            remove = c;
                            distance = machines[c].peek();
                        }
                    }

                    connected.remove(remove);
                    connected.add(arr[i]);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}