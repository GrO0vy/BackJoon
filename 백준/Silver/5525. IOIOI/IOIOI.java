import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int M = sc.nextInt();
        sc.nextLine();

        String str = sc.nextLine();

        int len = 0;
        int cnt = 0;

        for(int i = 0; i < M - 2; i++){
            if(str.charAt(i) == 'I' && isP(str, i + 1)){
                len++;
                i++;
            }
            else{
                if(len >= N){
                    cnt += len - N + 1;
                }
                len = 0;
            }
        }

        if(len >= N){
            cnt += len - N + 1;
        }

        System.out.println(cnt);
    }

    static boolean isP(String str, int start){
        return str.startsWith("OI", start);
    }
}