import java.io.*;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] in = new String[N];
        String[] out = new String[N];

        for(int i = 0 ; i < N; i++) in[i] = br.readLine();
        for(int i = 0 ; i < N; i++) out[i] = br.readLine();

        int result = 0;
        int target = 0;
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            set.add(out[i]);

            if(out[i].equals(in[target])) while(target < N && set.contains(in[target])) target++;
            else result++;
        }

        System.out.println(result);
    }
}