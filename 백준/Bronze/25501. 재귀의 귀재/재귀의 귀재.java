import java.util.Scanner;

public class Main{
    static int cnt;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();
        cnt = 0;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++){
            String str = sc.nextLine();
            int result = isPalindrome(str);

            sb.append(result + " " + cnt + "\n");
            cnt = 0;
        }

        System.out.println(sb);
    }

    static int isPalindrome(String str){
        return recursion(str, 0, str.length() - 1);
    }

    static int recursion(String str, int left, int right){
        cnt++;
        if(left >= right) return 1;
        else if(str.charAt(left) != str.charAt(right)) return 0;
        else return recursion(str, left + 1, right - 1);
    }
}