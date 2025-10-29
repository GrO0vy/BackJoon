// 1. 문자열 길이의 최대 공약수를 구한다.
// 2. 문자열 길이의 최소공배수를 구한다. (두 문자열 길이를 곱한 값에 최대공약수를 나눈다.)
// 3. 두 문자열을 최소공배수 길이가 될 때 까지 반복한다.
// 4. 반복한 두 문자열이 같으면 1을, 그렇지 않으면 0을 출력한다.

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();
        
        if(str1.length() < str2.length()){
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        
        int gcd = getGcd(str1.length(), str2.length());
        int lcd = str1.length() * str2.length() / gcd;
        
        String repeat1 = getRepeatStr(str1, lcd);
        String repeat2 = getRepeatStr(str2, lcd);
        
        if(repeat1.equals(repeat2)) System.out.println(1);
        else System.out.println(0);
    }
    
    static int getGcd(int n1, int n2){
        if(n2 == 0) return n1;
        
        return getGcd(n2, n1 % n2);
    }
    
    static String getRepeatStr(String str, int length){
        int repeat = length / str.length();
        
        return str.repeat(repeat);
    }
}