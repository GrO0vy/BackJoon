import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        int[][] arr = new int[str2.length() + 1][str1.length() + 1];
        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    arr[j][i] = arr[j - 1][i - 1] + 1;
                }
                else{
                    arr[j][i] = Math.max(arr[j - 1][i], arr[j][i - 1]);
                }
            }
        }

        System.out.println(arr[str2.length()][str1.length()]);
    }
}