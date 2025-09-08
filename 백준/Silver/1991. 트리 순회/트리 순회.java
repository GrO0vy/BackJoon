import java.io.*;
import java.util.*;

public class Main{
    static int N;
    static StringBuilder sb;
    static Map<Character, Child> map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        
        for(int i = 0; i < N; i++){
            String info = br.readLine();
            
            char parent = info.charAt(0);
            char left = info.charAt(2);
            char right = info.charAt(4);
            
            map.put(parent, new Child(left, right));
        }
        
        sb = new StringBuilder();
        
        preOrder('A');
        sb.append("\n");
        inOrder('A');
        sb.append("\n");
        postOrder('A');
        
        System.out.println(sb.toString());
    }
    
    static void preOrder(char node){
        if(node == '.') return;
        
        sb.append(node);
        preOrder(map.get(node).left);
        preOrder(map.get(node).right);
    }
    
    static void inOrder(char node){
        if(node == '.') return;
        
        inOrder(map.get(node).left);
        sb.append(node);
        inOrder(map.get(node).right);
    }
    
    static void postOrder(char node){
        if(node == '.') return;
        
        postOrder(map.get(node).left);
        postOrder(map.get(node).right);
        sb.append(node);
    }
    
    static class Child{
        char left;
        char right;
        
        public Child(char left, char right){
            this.left = left;
            this.right = right;
        }
    }
}