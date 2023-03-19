import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        while(true){
            int n = sc.nextInt();
            if(n==-1) break;
            
            int sum=0;
            for(int i =1; i<n; i++){
                if(n%i==0) sum+=i;
            }
            
            if(sum == n){
                System.out.printf("%d = 1 ",n);
                for(int i=2; i<n; i++){
                    if(n%i==0){
                        System.out.printf("+ %d ",i);
                    }
                }
                System.out.println();
            }
            else System.out.printf("%d is NOT perfect.\n",n);
        }
        
        sc.close();
    }
}