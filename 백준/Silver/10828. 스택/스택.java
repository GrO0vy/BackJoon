import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] stack = new int[count];
        int top = -1;
        
        for(int i = 0; i < count; i++){
            StringTokenizer commandInfo = new StringTokenizer(reader.readLine());
            String command = commandInfo.nextToken();
            
            switch(command){
                case "push":
                    stack[++top] = Integer.parseInt(commandInfo.nextToken());
                    break;
                case "pop":
                    if(top == -1) System.out.println(-1);
                    else System.out.println(stack[top--]);                   
                    break;
                case "size":
                    System.out.println(top + 1);
                    break;
                case "empty":
                    if(top == -1) System.out.println(1);
                    else System.out.println(0); 
                    break;
                case "top":
                    if(top == -1) System.out.println(-1);
                    else System.out.println(stack[top]);
                    break;
            }
        }
    }
    
    
}