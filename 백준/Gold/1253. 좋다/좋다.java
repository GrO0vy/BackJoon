import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list);

        int result = 0;

        for(int i = 0; i < N; i++){
            int start = 0;
            int end = N - 1;
            while(true){
                if(start == i) start++;
                if(end == i) end--;

                if(start >= end) break;

                int sum = list.get(start) + list.get(end);
                int target = list.get(i);

                if(sum > target) end--;
                else if(sum < target) start++;
                else{
                    result++;
                    break;
                }
            }
        }

        System.out.println(result);
    }
}