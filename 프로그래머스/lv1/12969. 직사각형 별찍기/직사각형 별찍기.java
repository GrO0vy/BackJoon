import java.util.Scanner;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int width = sc.nextInt();
        int height = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<height; i++){
            sb.append("*".repeat(width) +"\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
}