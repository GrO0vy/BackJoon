import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        String[] numbers = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine"};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        Number[] arr = new Number[N - M + 1];
        for(int i = M; i <= N; i++){
            int num = i;
            String str = "";

            while(num > 0){
                str = numbers[num % 10] + str;
                num /= 10;
            }

            arr[i - M] = new Number(i, str);
        }

        Arrays.sort(arr, new Comparator<>(){
            public int compare(Number o1, Number o2){
                return o1.str.compareTo(o2.str);
            }
        });

        for(int i = 0; i < arr.length; i++){
            if((i + 1) % 10 == 0) System.out.println(arr[i].decimal);
            else System.out.print(arr[i].decimal + " ");
        }
    }

    static class Number{
        int decimal;
        String str;

        public Number(int decimal, String str){
            this.decimal = decimal;
            this.str = str;
        }
    }
}