import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A[] arr = new A[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = new A(i, Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr, new Comparator<A>(){
            public int compare(A o1, A o2){
                return o1.value - o2.value;
            }
        });

        int rank = 0;
        for(int i = 1; i < N; i++){
            if(arr[i].value == arr[i - 1].value) arr[i].rank = rank;
            else arr[i].rank = ++rank;
        }

        Arrays.sort(arr, new Comparator<A>(){
            public int compare(A o1, A o2){
                return o1.idx - o2.idx;
            }
        });

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(arr[i].rank + " ");
        }

        System.out.println(sb);
    }

    static class A{
        int idx;
        int value;
        int rank;

        public A(int idx, int value){
            this.idx = idx;
            this.value = value;
            this.rank = 0;
        }
    }
}