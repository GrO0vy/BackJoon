import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String answer = "";
        for(int i = 0; i < a.length(); i++){
            char letter = a.charAt(i);
            if(a.charAt(i) > 90) answer += (char)(letter - 32);
            else answer += (char)(letter + 32);
        }
        System.out.println(answer);
    }
}