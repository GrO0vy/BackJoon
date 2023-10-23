import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n1 = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());
        int n3 = Integer.parseInt(br.readLine());
        
        int mul = n1 * n2 * n3;
        int[] count = new int[10];
        
        while(mul > 0){
            int num = mul % 10;
            count[num]++;
            mul /= 10;
        }
        
        for(int i = 0; i <= 9; i++){
            sb.append(count[i] + "\n");
        }
        
        System.out.println(sb);
        
        br.close();
    }
}