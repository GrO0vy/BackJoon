import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int result = 0;
        
        Stack<Integer> numberStack = new Stack<>();
        
        for(int i = 0; i < count; i++){
            int number = Integer.parseInt(reader.readLine());
            if(number == 0){
                numberStack.pop();
            }
            else numberStack.push(number);
        }
        
        while(!numberStack.isEmpty())
            result += numberStack.pop();
        
        System.out.println(result);
    }
}