import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String temp = str;
        String add = "";
        int idx = 0;

        while(!isPalindrome(temp)){
            add = str.charAt(idx) + add;
            temp = str + add;
            idx++;
        }

        System.out.println(temp.length());
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