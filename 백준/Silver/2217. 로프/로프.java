import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++){
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });

        int max = 0;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i] * (i + 1));
        }

        System.out.println(max);
        sc.close();
    }
}