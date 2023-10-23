import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] str = br.readLine().toCharArray();
        int[] count = new int[26];
        
        for(int i = 0; i < str.length; i++){
            int idx = str[i] - 'a';
            count[idx]++;
        }
        
        for(int i = 0; i < 26; i++){
            System.out.print(count[i] + " ");
        }
        
        br.close();
    }
}