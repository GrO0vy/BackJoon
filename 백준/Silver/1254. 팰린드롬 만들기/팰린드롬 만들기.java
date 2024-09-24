import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        int length = str.length();
        
        for(int i = 0; i < str.length() - 1; i++){
            if(isPalindrome(str.substring(i))) break;
            length++;
        }

        System.out.println(length);
    }

    static boolean isPalindrome(String str){
        int left = 0;
        int right = str.length() - 1;

        while(left < right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }

        return true;
    }
}