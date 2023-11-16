import java.util.*;
import java.io.*;

public class Main{
    static List<Integer> list1;
    static List<Integer> list2;
    static boolean flag = false;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list1 = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            list1.add(Integer.parseInt(st.nextToken()));
        }

        int M = Integer.parseInt(br.readLine());
        list2 = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < M; i++){
            list2.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(list1);

        StringBuilder sb = new StringBuilder();
        for(int num: list2){
            binarySearch(0, N - 1, num);
            if(flag) sb.append(1 + "\n");
            else sb.append(0 + "\n");
            flag = false;
        }

        System.out.println(sb);
    }

    static void binarySearch(int start, int end, int num){
        if(start > end) return;

        int mid = ( start + end ) / 2;
        int midVal = list1.get(mid);

        if(midVal == num ) {
            flag = true;
            return;
        }
        else if(num < midVal){
            binarySearch(start, mid - 1, num);
        }
        else binarySearch(mid + 1, end, num);
    }
}