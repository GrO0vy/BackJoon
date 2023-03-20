import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i=0; i<T; i++){
            int n = sc.nextInt();
            if(n%2==0){
                for(int j=n/2; j>=2; j--){
                    if(isSosu(j) && isSosu(n-j)){
                        System.out.printf("%d %d\n",j,n-j);
                        break;
                    }
                }
            }
        }
    }
    
    static boolean isSosu(int num){
        int count =0;
        for(int i=1; i<=num; i++){
            if(num%i ==0) count++;
        }
        if(count == 2) return true;
        return false;
    }
}