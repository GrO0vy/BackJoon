import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        char[][] chars = new char[5][];
        int max_size=0;
        
        for(int i=0; i<5; i++){
            String s = sc.next();
            chars[i] = new char[s.length()];
            
            for(int j=0; j<s.length(); j++){
                chars[i][j] = s.charAt(j);
            }
        }
        
        for(char[] c : chars){
            if(max_size < c.length){
                max_size = c.length;
            }
        }
        
        for(int i=0; i<max_size; i++){
            for(int j=0; j<5; j++){
            	if(chars[j].length<i+1) continue;
                System.out.print(chars[j][i]);
            }
        }
        
        sc.close();
    }
}