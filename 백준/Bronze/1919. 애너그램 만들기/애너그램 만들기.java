import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] s1 = br.readLine().toCharArray();
        char[] s2 = br.readLine().toCharArray();
        
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        
        for(int i = 0; i < s1.length; i++){
            s1Count[s1[i] - 'a']++;
        }
        
        for(int i = 0; i < s2.length; i++){
            s2Count[s2[i] - 'a']++;
        }
        
        int result = 0;
        
        for(int i = 0; i < 26; i++){
            result += Math.abs(s1Count[i] - s2Count[i]);
        }
        
        System.out.println(result);
        
        br.close();
    }
}