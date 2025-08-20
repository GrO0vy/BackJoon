import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        List<Emblem> emblemList = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            int power = Integer.parseInt(st.nextToken());
            
            emblemList.add(new Emblem(name, power));
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < M; i++){
            int power = Integer.parseInt(br.readLine());
            
            int left = 0;
            int right = N - 1;
            int result = 0;
            
            while(left <= right){
                int mid = (left + right) / 2;
                
                if(power <= emblemList.get(mid).power){
                    result = mid;
                    right = mid - 1;
                }
                else{
                    left = mid + 1;    
                }
            }
            
            sb.append(emblemList.get(result).name + "\n");
        }
        
        System.out.println(sb.toString());
    }
    
    static class Emblem{
        String name;
        int power;
        
        public Emblem(String name, int power){
            this.name = name;
            this.power = power;
        }
    }
}