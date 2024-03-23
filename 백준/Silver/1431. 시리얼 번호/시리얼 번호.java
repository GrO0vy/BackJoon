import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for(int i = 0; i < N; i++){
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<>(){
            public int compare(String o1, String o2){
                if(o1.length() == o2.length()){
                    int sum1 = 0;
                    int sum2 = 0;

                    for(int i = 0; i < o1.length(); i++){
                        char c = o1.charAt(i);
                        if(c < 'A') sum1 += c - '0';
                    }

                    for(int i = 0; i < o2.length(); i++){
                        char c = o2.charAt(i);
                        if(c < 'A') sum2 += c - '0';
                    }

                    if(sum1 == sum2) return o1.compareTo(o2);
                    else return sum1 - sum2;
                }
                else return o1.length() - o2.length();
            }
        });

        for(int i = 0; i < N; i++){
            System.out.println(arr[i]);
        }
    }
}