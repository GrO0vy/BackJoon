import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String target = br.readLine();
        
        int cnt = 0;
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String str = br.readLine().repeat(2);
            if(str.contains(target)) cnt++;
        }
        
        System.out.println(cnt);
    }
}