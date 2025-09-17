import java.util.*;
import java.io.*;

public class Main{
    static StringBuilder sb;
    static TreeSet<Integer> attractions;
    static int N;
    static int Q;
    static int arr[];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        sb = new StringBuilder();
        attractions = new TreeSet<>();
        
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] == 1) addAttraction(i);
        }
        
        int pos = 0;
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            
            int command = Integer.parseInt(st.nextToken());
            
            if(command == 1){
                int place = Integer.parseInt(st.nextToken()) - 1;
                
                if(arr[place] == 0){
                    arr[place] = 1;
                    addAttraction(place);
                }
                else{
                    arr[place] = 0;
                    removeAttraction(place);
                }
            }
            else if(command == 2){
                int move = Integer.parseInt(st.nextToken());
                pos = (pos + move) % N;
            }
            else{
                printOutput(pos);      
            }
        }
        
        System.out.println(sb.toString());
    }
    
    static void addAttraction(int addData){
        attractions.add(addData);    
    }
    
    static void removeAttraction(int removeData){
        attractions.remove(removeData);        
    }
    
    static void printOutput(int pos){
        Integer nearest = attractions.ceiling(pos);
        
        if(nearest != null) sb.append((nearest - pos));
        else{
            if(!attractions.isEmpty()) sb.append(N - pos + attractions.first());
            else sb.append(-1);
        }
        
        sb.append("\n");
    }
}