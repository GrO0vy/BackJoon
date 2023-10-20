import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] scores = new int[N];
        int maxScore = 0;
        
        for(int i = 0; i < N; i++){
            int score = Integer.parseInt(st.nextToken());
            scores[i] = score;
            
            if(score > maxScore) maxScore = score;
        }
        
        double sum = 0;
        double avg = 0;
        
        for(int i = 0; i < N; i++){
            sum += scores[i] / (double)maxScore * 100;
        }
        
        avg = sum / (double)N;
        
        System.out.println(avg);
        
        br.close();
    }
}