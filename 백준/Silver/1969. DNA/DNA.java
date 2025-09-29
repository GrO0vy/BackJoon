import java.io.*;
import java.util.*;

public class Main{
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        String[] dna = new String[N];
        int[][] cntLetter = new int[M][26];
        
        for(int i = 0; i < N; i++) {
            dna[i] = br.readLine();
            
            for(int j = 0; j < M; j++){
                cntLetter[j][dna[i].charAt(j) - 'A']++;    
            }
        }
        
        StringBuilder result = new StringBuilder();
        int sum = 0;
        
        for(int i = 0; i < M; i++){
            char letter = 'A';
            int cntCorrect = 0;
            int hammingDistance = 0;
            
            for(int j = 0; j < 26; j++){
                if(cntLetter[i][j] > cntCorrect){
                    letter = (char)('A' + j);
                    cntCorrect = cntLetter[i][j];
                }
                
                hammingDistance += cntLetter[i][j];
            }
            
            hammingDistance -= cntCorrect;
            
            result.append(letter);
            sum += hammingDistance;
        }
        
        System.out.println(result.toString());
        System.out.println(sum);
    }
}