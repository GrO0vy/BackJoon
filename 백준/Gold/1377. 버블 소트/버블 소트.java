import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        A[] arr = new A[N];

        for(int i = 0; i < N; i++){
            arr[i] = new A(i, Integer.parseInt(br.readLine()));
        }

        Arrays.sort(arr, (o1, o2) ->{
            return o1.value - o2.value;
        });

        int answer = 0;
        for(int i = 0; i < N; i++){
            answer = Math.max(answer, arr[i].index - i);
        }

        System.out.println(answer + 1);
    }

    static class A{
        int value;
        int index;

        public A(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
}