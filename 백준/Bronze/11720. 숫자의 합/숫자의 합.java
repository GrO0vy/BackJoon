import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int count = Integer.parseInt(br.readLine());
        int sum = 0;
        
        for(int i = 0; i < count; i++){
            int number = br.read() - 48;
            sum += number;
        }
        
        bw.write(String.valueOf(sum));
        
        bw.close();
        br.close();
    }
}